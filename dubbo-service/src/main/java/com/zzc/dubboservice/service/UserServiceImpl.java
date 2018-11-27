package com.zzc.dubboservice.service;

import com.zzc.dubboapi.api.UserService;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-27 9:34
 * Description:
 **/

public class UserServiceImpl implements UserService {


    @Override
    public String getUser(String id) {
        return id + " -- service";
    }
}
