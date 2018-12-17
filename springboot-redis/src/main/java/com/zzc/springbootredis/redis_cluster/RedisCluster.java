package com.zzc.springbootredis.redis_cluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 访问redis集群
 * @author 图灵-诸葛老师
 *
 */
public class RedisCluster 
{
    public static void main(String[] args) throws IOException
    {
        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("47.107.171.101", 8001));
        jedisClusterNode.add(new HostAndPort("47.107.171.101", 8002));
        jedisClusterNode.add(new HostAndPort("47.107.171.102", 8003));
        jedisClusterNode.add(new HostAndPort("47.107.171.101", 8004));
        jedisClusterNode.add(new HostAndPort("47.107.171.101", 8000));
        jedisClusterNode.add(new HostAndPort("47.107.171.101", 8006));
        
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);
        config.setTestOnBorrow(true);
        //connectionTimeout：指的是连接一个url的连接等待时间
        //soTimeout：指的是连接上一个url，获取response的返回等待时间
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNode, 6000, 5000, 10, "zzc", config);
//        System.out.println(jedisCluster.set("student", "zzc"));
//        System.out.println(jedisCluster.set("age", "111"));
//
//        System.out.println(jedisCluster.get("student"));
        System.out.println(jedisCluster.get("age"));
        
        jedisCluster.close();
    }
}
