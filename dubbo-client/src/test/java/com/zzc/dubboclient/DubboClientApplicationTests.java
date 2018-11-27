package com.zzc.dubboclient;

import com.zzc.dubboclient.teacher.GodseyeTest;
import com.zzc.dubboclient.teacher.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboClientApplicationTests {


    @Autowired
    GodseyeTest godseyeTest ;
    @Autowired
    Teacher teacher ;

    @Test
    public void contextLoads() {

        for (int i = 0; i < 50; i++) {

            String s = teacher.getUserById("zzc");
            System.out.println(s);
        }
    }


    @Test
    public void godsEys(){
        for (int i = 0; i < 50; i++) {
            godseyeTest.get();
        }
    }

}
