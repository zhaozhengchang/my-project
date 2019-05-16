package com.generator.generatorresulttest;

import com.mapper.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorResultTestApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads() {
        userDao.selectByPrimaryKey("355353453453534534");
    }

}

