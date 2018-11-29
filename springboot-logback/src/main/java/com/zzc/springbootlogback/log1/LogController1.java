package com.zzc.springbootlogback.log1;

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
public class LogController1 {

    @GetMapping("/log1")
    public void log() throws InterruptedException {
        long start = System.currentTimeMillis();
        MDC.put("zzc1","v1");
        MDC.put("zzc2","v2");
        for (int i = 0; i < 1; i++) {
            log.info("********log1*********info" + i);
            log.warn("********log1*********warn" + i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }


}
