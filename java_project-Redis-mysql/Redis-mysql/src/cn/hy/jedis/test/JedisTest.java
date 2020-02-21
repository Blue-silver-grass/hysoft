package cn.hy.jedis.test;


import cn.hy.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis测试类
 */
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.set("username","zhangsan");
        //3.关闭连接
        jedis.close();
    }

    /**
     * JedisPool jedis连接池
     */
    @Test
    public void Test7(){
        //创建一个配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);
        //创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        //获取连接
        Jedis jedis = jedisPool.getResource();
        //操作
        jedis.set("heihei","haha");
        String heihei = jedis.get("heihei");
        System.out.println(heihei);
        //关闭 归还到连接池
        jedis.close();
    }

    /**
     * JedisPoolUtils jedis连接池
     */
    @Test
    public void Test8(){
        //创建一个配置对象
        Jedis jedis = JedisPoolUtils.getJedis();
        //操作
        jedis.set("hello","world");
        String heihei = jedis.get("hello");
        System.out.println(heihei);
        //关闭 归还到连接池
        jedis.close();
    }
}
