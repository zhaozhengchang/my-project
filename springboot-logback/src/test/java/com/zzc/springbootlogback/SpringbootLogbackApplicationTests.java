package com.zzc.springbootlogback;

import com.zzc.springbootlogback.controller.LogController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootLogbackApplicationTests {

    @Autowired
    LogController logController ;

    @Test
    public void contextLoads() throws InterruptedException {
        Long sum = 0L;
        int  count = 10 ;
        for (int i = 0; i < count; i++) {
            sum += logController.log("userid111","name111");
        }
        System.out.println("总耗时：" + sum +" ms ，平均耗时：" + sum/count);

    }

}
