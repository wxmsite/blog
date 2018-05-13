package com.blog.pv;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class PvCount {

    //jedis池
    private static JedisPool pool;

    //静态代码初始化池配置
    static {
        //加载redis配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        if (bundle == null) {
            throw new IllegalArgumentException("[redis.properties] is not found!");
        }
        //创建jedis池配置实例
        JedisPoolConfig config = new JedisPoolConfig();
        //设置池配置项值
        config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxTotal")));
        config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
        config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWait")));

        //根据配置实例化jedis池
        pool = new JedisPool(config, bundle.getString("redis.ip"),
                Integer.valueOf(bundle.getString("redis.port")));
    }

    /**
     * 测试jedis池方法
     */
    public static void blog1() {
        //从jedis池中获取一个jedis实例
        Jedis jedis = pool.getResource();

        //获取jedis实例后可以对redis服务进行一系列的操作
        jedis.set("name", "xmong");
        System.out.println(jedis.get("name"));
        jedis.del("name");
        System.out.println(jedis.exists("name"));

        //释放对象池，即获取jedis实例使用后要将对象还回去
        pool.returnResource(jedis);
    }

    public static void main(String[] args) {
        blog1();//执行blog1方法
    }

}
