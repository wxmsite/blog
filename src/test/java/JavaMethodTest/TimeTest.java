package JavaMethodTest;

import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author bebetter159
 * date  2018/6/2 15:07
 */

public class TimeTest {

    @Test
    public void testTime() throws ParseException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        String str = "2018-06-4 23:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = (Date) sdf.parse(str);
        System.out.println(date.getTime());

    }
}
