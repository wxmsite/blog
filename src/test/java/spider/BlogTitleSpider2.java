package spider;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
/**
 * author bebetter159
 * date  2018/5/19 21:24
 */
/**
 * 爬取Title后发现有些url爬取失败，这里目的是根据url重新爬取那些失败的博客，暂时认为爬取失败的原因是网络原因
 * 有时间再填坑
 */
public class BlogTitleSpider2 implements PageProcessor {
    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return null;
    }
}
