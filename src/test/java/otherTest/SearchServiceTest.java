package otherTest;

import com.blog.model.Blog;
import com.blog.model.BlogDetail;
import com.blog.service.SearchService;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * author bebetter159
 * date  2018/6/2 20:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class SearchServiceTest {
    @Autowired
    SearchService searchService;
    @Test
    public void test(){
        List<BlogDetail> list=searchService.searchBlogLucene("1",1);
        for(BlogDetail blogDetail:list){
            System.out.println(blogDetail.getTitle());
        }
    }

}
