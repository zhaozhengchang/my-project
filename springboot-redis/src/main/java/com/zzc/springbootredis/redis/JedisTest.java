package com.zzc.springbootredis.redis;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-09 16:21
 * Description:
 **/

public class JedisTest {



    	    public static void main(String[] args) {

                   UserInfoCache.cacheUserTokens("user1",new User("zzc",5));

                   User u1 = UserInfoCache.getUserTokens("user1", User.class);
                   System.out.println(u1);

//                   UserInfoCache.removeUserTokens("user1","zzc");

    	        }
}
