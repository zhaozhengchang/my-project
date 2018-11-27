package com.zzc.dubboclient;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * CreateDate：2018/11/20
 * Author：yangfan
 * Description: 该类用于注入通用的bean
 */
@Configuration
@ImportResource("classpath:dubbo-config.xml")
public class CommonConfiguration {


}
