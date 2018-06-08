package BlogTest;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author bebetter159
 * date  2018/6/7 20:13
 */
public class SeckillTest {
    JedisPool jedisPool=new JedisPool();
    @Test
    public void setTime() throws ParseException {
        String str="2018-06-07 20:47:20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = (Date) sdf.parse(str);
        Jedis jedis=jedisPool.getResource();
        jedis.set("seckillTime", String.valueOf(date.getTime()));
    }
}
