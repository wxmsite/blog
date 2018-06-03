package otherTest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author bebetter159
 * date  2018/6/2 15:07
 */
public class TimeTest {
    @Test
    public void testTime(){
       System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

    }
}
