package com.example.demo;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-23 16:15
 * Description:
 **/

public class Test {

    public static void main(String[] args) {
        InputStream inputStream = Test.class.getResourceAsStream("/zzc.properties");
        Properties redisProperties = new Properties();
        try {
            redisProperties.load(inputStream);
        } catch (IOException e) {
        }

        String s = redisProperties.getProperty("zzc.name");
        System.out.println(s);
        }


}
