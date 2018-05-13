import com.blog.model.UserInfo;
import com.blog.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class UserTest {
    @Autowired
    UserInfoService userInfoService;

    @Test
    public void test() {
        UserInfo userInfo=userInfoService.getUserByName("1");
        System.out.println("用户信息"+userInfo.toString());
    }
}
