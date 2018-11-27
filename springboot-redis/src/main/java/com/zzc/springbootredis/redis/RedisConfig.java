package com.zzc.springbootredis.redis;

import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * author: lijianpeng
 * date: 2018/10/12 19:14
 */
public class RedisConfig {


    private static RedisConfig instance = null;

    private JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

    private String redisHost = null;

    private Integer redisPort = null;

    private Integer redisConnectTimeout = null;

    private RedisConfig() {
        loadConfigFromProperties();
    }

    public  static RedisConfig getInstance(){
        if (instance == null){
            synchronized (RedisConfig.class){
                if (instance == null){
                    instance = new RedisConfig();
                }
            }
        }
        return instance;
    }

    public JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }

    public String getRedisHost() {
        return redisHost;
    }

    public Integer getRedisPort() {
        return redisPort;
    }

    public Integer getRedisConnectTimeout() {
        return redisConnectTimeout;
    }

    private void loadConfigFromProperties(){
        InputStream inputStream = this.getClass().getResourceAsStream("/redis.properties");
        Properties redisProperties = new Properties();
        try {
            redisProperties.load(inputStream);
        } catch (IOException e) {
        }

        this.jedisPoolConfig.setMaxTotal(Integer.parseInt(redisProperties.getProperty("redis.maxTotal")));
        this.jedisPoolConfig.setMaxIdle(Integer.parseInt(redisProperties.getProperty("redis.maxIdle")));
        this.jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(redisProperties.getProperty("redis.maxWaitMillis")));
        //在每次向jedisPool请求实例时，对请求到的实例进行可用性检查
        this.jedisPoolConfig.setTestOnBorrow(Boolean.valueOf(redisProperties.getProperty("redis.testOnBorrow")));

        this.redisHost = redisProperties.getProperty("redis.host");
        this.redisPort = Integer.parseInt(redisProperties.getProperty("redis.port"));
        this.redisConnectTimeout = Integer.parseInt(redisProperties.getProperty("redis.timeout"));

    }
}
