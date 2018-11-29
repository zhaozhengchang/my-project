package com.zzc.springbootlogback.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-23 14:08
 * Description:
 **/
@RestController
@Slf4j
public class LogController {

    @GetMapping("/log")
    public Long log(String userid,String name) throws InterruptedException {
        long start = System.currentTimeMillis();
        try {
            MDC.put("zzc",name);
            for (int i = 0; i < 1; i++) {
                log.info("*****************info" + i);
                log.warn("*****************warn" + i);
            }
            String s = null ;
        }catch (Exception e){
            log.error("异常：",e);
        }
//        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        return (System.currentTimeMillis() - start) ;
    }


}
