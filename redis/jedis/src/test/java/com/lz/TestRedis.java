package com.lz;

import redis.clients.jedis.Jedis;

/**
 * @author lihao
 * @date 2022-01-11 20:39
 */
public class TestRedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("101.133.163.204",6379);
        jedis.set("name","jay");
        System.out.println(jedis.get("name"));
    }
}
