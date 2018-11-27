package com.zzc.javabase.base;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-27 17:07
 * Description:
 *
 * 使用Class类的方法获取某配置文件内容
 *
 **/
@Slf4j
public class PropertiesTest {

    public static void main(String[] args) {

        Class clazz = PropertiesTest.class;
        InputStream inputStream = clazz.getResourceAsStream("/zzc.properties");
        Properties redisProperties = new Properties();
        try {
            redisProperties.load(inputStream);
        } catch (IOException e) {
            log.error("load inputStream error,",e);
        }


        //获取此配置文件中的具体某个key
        String s = redisProperties.getProperty("zzc");
        System.out.println("zzc = "+s);

        //获取此配置文件中所有的key
        Enumeration enumeration = redisProperties.propertyNames();
        while(enumeration.hasMoreElements()){
            String element = enumeration.nextElement().toString() ;
            System.out.println("key : "+element);
        }

    }


    }
