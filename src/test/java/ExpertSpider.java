import com.blog.Mapper.ExpertBlogMapper;
import com.blog.model.ExpertUrl;
import com.blog.service.ExpertBlogService;
import com.blog.service.impl.ExpertBlogServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class ExpertSpider implements PageProcessor {

    private static ApplicationContext ctx = null;
    private static ExpertBlogService expertBlogService;
    private static ExpertBlogMapper expertBlogMapper;
    ExpertUrl expertUrl;

    //When you use @Autowired in a new thread,you will get a nullpointerException
    static {
        ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        expertBlogMapper = (ExpertBlogMapper) ctx.getBean("expertBlogMapper");
        expertBlogService = new ExpertBlogServiceImpl(expertBlogMapper);
    }


    // 这个是列表页
    public static final String EXPERTS_LIST = "http://blog\\.csdn\\.net/peoplelist\\.html\\?channelid=0\\&page="
            + "\\w+";

    // 博客详情页
    // public static final String EXPERTS_DETAILS =
    // "http://blog.csdn.net/\\w+";// \\w+是一个匹配符，可以匹配任意字段
    private Site site = Site.me().setDomain("blog.csdn.net").setSleepTime(300).setUserAgent(
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public void process(Page page) {
        String work = null;
        String place = null;

        // 列表页： 这里进行匹配，匹配出列表页进行相关处理。
        if ((page.getUrl()).regex(EXPERTS_LIST).match()) {
            // 遍历出div[@class=\"page_nav\"]节点下的所有超链接，这里的超链接是分页的超链接，可以进行分页。
            page.addTargetRequests(
                    page.getHtml().xpath("//div[@class=\"page_nav\"]").links().regex(EXPERTS_LIST).all());// 是一个正则规则，校验使用，可以省略。

            // 获取专家列表元素
            //使用Selectable以进行页面元素的链式抽取
            Selectable selectable = page.getHtml().xpath("//dl[@class=\"experts_list\"]");
            //根据xpath来获取相关信息
            for (Selectable s : selectable.nodes()) {

                String url = s.xpath("//a[@class=\"expert_name\"]").links().toString();
                String avatarUrl = s.xpath("//img[@class=\"expert_head\"]/@src").toString();

                String name = s.xpath("//a[@class=\"expert_name\"]/text()").toString();

                place = s.xpath("//div[@class=\"address\"]//em/tidyText()").toString();
                work = s.xpath("//div[@class=\"address\"]//span/tidyText()").toString();

                String articleNum = s.xpath("//div[@class=\"count_l fl\"]//b/tidyText()").toString();
                String readNum = s.xpath("//div[@class=\"count_l fr\"]//b/tidyText()").toString();
                // 开始组装数据
                if (place == null) {
                    work = null;

                }
                try {
                    expertUrl = new ExpertUrl(avatarUrl, url, name, place, work, Integer.valueOf(readNum), Integer.valueOf(articleNum));
                    expertBlogService.insertUrl(expertUrl);
                } catch (Exception e) {
                    System.out.println(expertUrl.toString());
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Test
    public void insertTest() {
        Spider.create(new ExpertSpider()).addUrl("http://blog.csdn.net/peoplelist.html?channelid=0&page=1").thread(5).run();
    }



}
