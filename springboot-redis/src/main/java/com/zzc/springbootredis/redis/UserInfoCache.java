package com.zzc.springbootredis.redis;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-06 15:00
 * Description: 缓存username 跟 token，作用是判断用户是否在别处登录
 **/
public class UserInfoCache {

    private final static String USER_TOKENS = "userTokens";
    private final static String TOKENS_USER = "tokensUser";
    private final static String USER_SESSION = "userSession";

    private static JedisPool jedisPool = RedisClientPool.getJedisPool();
    private static Jedis jedis = null;

    /**
     * 获取Jedis实例
     *
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
                return jedis;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void cacheUserTokens(String userName, User user) {
        try {
            getJedis().hset(USER_TOKENS, userName, JSON.toJSONString(user));
        } finally {
            returnResource();
        }
    }

    public static void removeUserTokens(String userName, String token) {
        try {
            getJedis().hdel(USER_TOKENS, userName);
        } finally {
            returnResource();
        }
    }

    public static <T> T getUserTokens(String userName, Class<T> clazz) {
        try {
            String objString = getJedis().hget(USER_TOKENS, userName) ;
            T obj = JSON.parseObject(objString , clazz);
            return obj;
        } finally {
            returnResource();
        }
    }

    /**
     * 释放jedis资源
     */
    public static void returnResource() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
