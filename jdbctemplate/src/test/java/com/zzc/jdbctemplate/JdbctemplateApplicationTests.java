package com.zzc.jdbctemplate;

import com.zzc.jdbctemplate.jdbctemplate.JdbcTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbctemplateApplicationTests {

    @Autowired
    JdbcTest jdbcTest;
    @Test
    public void contextLoads() {
        String s = jdbcTest.get();
        System.out.println(s);
    }

}
