import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class ExpertBlogSpider implements PageProcessor {
    public static final String EXPERTS_LIST = "https://blog.csdn.net/yanghua_kobe/article/list/"
            + "\\w+";
    private Site site = Site.me().setDomain("blog.csdn.net").setSleepTime(300).setUserAgent(
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public void process(Page page) {
        if ((page.getUrl()).regex(EXPERTS_LIST).match()) {
            // 遍历出div[@class=\"page_nav\"]节点下的所有超链接，这里的超链接是分页的超链接，可以进行分页。
            page.addTargetRequests(
                    page.getHtml().xpath("//div[@class=\"page_nav\"]").links().regex(EXPERTS_LIST).all());// 是一个正则规则，校验使用，可以省略。

            // 获取专家列表元素
            //使用Selectable以进行页面元素的链式抽取
            Selectable selectable = page.getHtml().xpath("//dl[@class=\"experts_list\"]");
            //根据xpath来获取相关信息
            for (Selectable s : selectable.nodes()) {




            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
