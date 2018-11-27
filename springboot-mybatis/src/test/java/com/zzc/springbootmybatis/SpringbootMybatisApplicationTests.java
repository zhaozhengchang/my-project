package com.zzc.springbootmybatis;

import com.zzc.springbootmybatis.dal.UserDao;
import com.zzc.springbootmybatis.dal.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootMybatisApplicationTests {

    @Autowired
    UserDao userDao;



    @Test
    public void contextLoads() {
        User user = userDao.getUser_zhujie("zzc");
        User user1 = userDao.getUser("zy");
        System.out.println(user.toString());
        System.out.println(user1);
    }

    @Test
    public void updateUser(){
        int a = userDao.updateUser("zzc");
        System.out.println("*************"+a);
    }

}
