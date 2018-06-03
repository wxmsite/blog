package spider;

import com.blog.Mapper.ExpertUrlMapper;
import com.blog.model.BlogUrl;
import com.blog.model.ExpertUrl;
import com.blog.service.ExpertUrlService;
import com.blog.service.impl.ExpertUrlServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * author bebetter159
 * date  2018/5/18 23:15
 */
/**
 * 爬取博客标题，本来是和博客内容一起爬取的，后来由于某些原因就只爬取了title
 */
public class BlogTitleSpider implements PageProcessor {
    private static ApplicationContext ctx = null;
    private static ExpertUrlService expertUrlService;
    private static ExpertUrlMapper expertUrlMapper;
    //eid必须使用声明为static，原因见StaticTest

    private final static ThreadLocal<BlogUrl> blogUrl = new ThreadLocal<>();
    private Site site = Site.me().setDomain("blog.csdn.net").setRetryTimes(3).setSleepTime(1000).setUserAgent(
            "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50");

    static {
        ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        expertUrlMapper = (ExpertUrlMapper) ctx.getBean("expertUrlMapper");
        expertUrlService = new ExpertUrlServiceImpl(expertUrlMapper);
    }

    /**
     * 读取每个page里面的blog的url并且存入数据库
     *
     * @param page
     */

    @Override
    public void process(Page page) {

        List<String> url = page.getHtml().xpath("//*[@id=\"mainBox\"]/main/div[2]/*/h4/a").links().all();
        List<String> title = page.getHtml().xpath("//*[@id=\"mainBox\"]/main/div[2]/*/h4/a/text()").all();
        List<String> time = page.getHtml().xpath("//*[@id=\"mainBox\"]/main/div[2]/*/div/p[1]/span/text()").all();
        List<String> read = (page.getHtml().xpath("//*[@id=\"mainBox\"]/main/div[2]/*/div/p[2]/span/text()").all());
        List<String> comment = (page.getHtml().xpath("//*[@id=\"mainBox\"]/main/div[2]/*/div/p[3]/span/text()").all());
        for (int i = 0; i < url.size(); i++) {
           /*  System.out.println(url.get(i)+title.get(i) + time.get(i) + Integer.parseInt(read.get(i).substring(4,
                     read.get(i).length()))+Integer.parseInt(comment.get(i).substring(4,comment.get(i).length())));*/
            expertUrlService.updateBlogUrl(url.get(i), title.get(i) , time.get(i) , Integer.parseInt(read.get(i).substring(4,
                    read.get(i).length())),Integer.parseInt(comment.get(i).substring(4,comment.get(i).length())));
        }


    }

    @Override
    public Site getSite() {
        return site;
    }

    @Test
    public void insertTest() throws InterruptedException {

        List<ExpertUrl> list = expertUrlService.getAllExpertUrl();
        for (ExpertUrl expertUrl : list) {

            int pages = expertUrl.getArticleNum() / 20 + 1;
            String[] strings = new String[pages];
            for (int i = 1; i <= pages; i++) {
                strings[i - 1] = expertUrl.getExpertUrl() + "/article/list/" + i;
            }
            //对应静态的eid变量，由于声明了新对象，所以process获取的变量会为0
            Spider.create(new BlogTitleSpider()).addUrl(strings).thread(18).run();
        }
    }


}
