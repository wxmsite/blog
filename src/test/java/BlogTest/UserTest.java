package BlogTest;

import com.blog.model.User;
import com.blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

/**
 * author bebetter159
 * date  时间未详
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class UserTest {
    @Autowired
    UserService userService;


    @Test
    public void test() {
        User user = userService.getUserByName("1");
        System.out.println("用户信息"+ user.toString());

    }
}
