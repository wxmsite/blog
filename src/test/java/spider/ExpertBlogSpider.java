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
 * date  时间未详
 */
/**
 * 这个类其实可以和lBlogTitleSpider合并，由于初期想先爬博客url所以将其拆分开了
 * 后来发现暂时只需要个Title所以就可以合并两个类
 * 如果需要爬取博客内容，还需要通过爬取article/details，这里不再提供代码
 */
public class ExpertBlogSpider implements PageProcessor {
    private static ApplicationContext ctx = null;
    private static ExpertUrlService expertUrlService;
    private static ExpertUrlMapper expertUrlMapper;
    //eid必须使用声明为static，原因见StaticTest
    private static int eid;
    private final static ThreadLocal<BlogUrl> blogUrl = new ThreadLocal<>();
    private Site site = Site.me().setDomain("blog.csdn.net").setSleepTime(300).setUserAgent(
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    static {
        ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        expertUrlMapper = (ExpertUrlMapper) ctx.getBean("expertUrlMapper");
        expertUrlService = new ExpertUrlServiceImpl(expertUrlMapper);
    }

    /**
     * 读取每个page里面的blog的url并且存入数据库
     * @param page
     */

    @Override
    public void process(Page page) {
        if ((page.getUrl()).regex("http://blog.csdn.net/\\w+/article/list/[0-9]*[1-9][0-9]*$").match()) {
            // 遍历出div[@class=\"article-list\"]节点下的所有超链接，这里的超链接是分页的超链接，可以进行分页。
            page.addTargetRequests(page.getHtml().xpath("//div[@class=\"article-list\" ]").links().all());
        } else if (page.getUrl().regex("https://blog.csdn.net/\\w+/article/details/\\w+").match()) {
            blogUrl.set(new BlogUrl(getEid(), page.getUrl().toString()));
            expertUrlService.insertBlogUrl(blogUrl.get());
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    @Test
    public void insertTest() {
        List<ExpertUrl> list = expertUrlService.getAllExpertUrl();
        for (ExpertUrl expertUrl : list) {
            setEid(expertUrl.getEid());
            int pages = expertUrl.getArticleNum() / 20 + 1;
            String[] strings = new String[pages];
            for (int i = 1; i <= pages; i++) {
                strings[i - 1] = expertUrl.getExpertUrl() + "/article/list/" + i;
            }
            System.out.println(getEid());
            //对应静态的eid变量，由于声明了新对象，所以process获取的变量会为0
            Spider.create(new ExpertBlogSpider()).addUrl(strings).thread(1).run();
        }
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }
}
