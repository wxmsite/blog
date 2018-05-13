import com.blog.model.ExpertBlog;
import com.blog.model.ExpertUrl;
import com.blog.service.ExpertBlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class ExpertTest {
    @Autowired
    ExpertBlogService expertBlogService;

    @Test
    public void expertUrlTest() {
        ExpertUrl expertUrl = new ExpertUrl("1", "2", "3", "4", "5", 6, 7);
        expertBlogService.insertUrl(expertUrl);

        expertBlogService.deleteUrl("2");


    }

    @Test
    public void expertBlogTest() {
        ExpertBlog expertBlog = new ExpertBlog( 2, "2", "3", "4", new Date(111111), 100, 200);
        expertBlogService.insertBlog(expertBlog);
        expertBlogService.deleteBlog(1);
    }


}
