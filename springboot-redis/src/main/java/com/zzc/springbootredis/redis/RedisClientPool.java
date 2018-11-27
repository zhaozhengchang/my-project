package com.zzc.springbootredis.redis;

import redis.clients.jedis.JedisPool;

/**
 * author: lijianpeng
 * date: 2018/10/13 12:02
 */
public class RedisClientPool {

    private static RedisClientPool instance = null;

    private JedisPool jedisPool = null;

    private RedisClientPool() {
        createJedisPool();
    }

    private static RedisClientPool getInstance() {
        if (instance == null){
            synchronized (RedisClientPool.class){
                if (instance == null){
                    instance = new RedisClientPool();
                }
            }
        }
        return instance;
    }

    public static JedisPool getJedisPool() {
        return  getInstance().jedisPool;
    }

    private void createJedisPool(){
        RedisConfig redisConfig = RedisConfig.getInstance();

        JedisPool jedisPool = new JedisPool(redisConfig.getJedisPoolConfig(),
                                            redisConfig.getRedisHost(),
                                            redisConfig.getRedisPort(),
                                            redisConfig.getRedisConnectTimeout());

        this.jedisPool = jedisPool ;
//        return jedisPool;
    }


}
