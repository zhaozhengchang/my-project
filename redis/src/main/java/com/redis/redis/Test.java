package com.redis.redis;

import redis.clients.jedis.Jedis;

/**
 * @author zhaoZhengchang
 * @create_date 2019-01-08 16:36
 * Description:
 **/

public class Test {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.107.171.101", 8004);
        jedis.auth("zzc");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println("****************" + value);

    }
}
