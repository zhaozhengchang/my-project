package com.zzc.springbootlogback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-23 14:08
 * Description:
 **/
@RestController
@Slf4j
public class LogController {

    @GetMapping("/log")
    public void log() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            log.info("*****************info" + i);
            log.warn("*****************warn" + i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }


}
