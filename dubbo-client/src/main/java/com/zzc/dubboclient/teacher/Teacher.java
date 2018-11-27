package com.zzc.dubboclient.teacher;

import com.zzc.dubboapi.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-27 9:27
 * Description:
 *
 * 1.dubbo 默认的负载均衡方式是随机+权重，使用这种就好了，如果存在反应慢的服务的话，会自动给少分配任务.
 * 2.zookeeper里面存放的服务其实就是  接口全路径 只要client接口全路径跟服务端提供的一致，就可以调用服务接口。
 **/
@Component
public class Teacher {

    @Autowired
    UserService userService ;

    public String getUserById(String id){

        String result = userService.getUser(id);

       return result;
    }

}
