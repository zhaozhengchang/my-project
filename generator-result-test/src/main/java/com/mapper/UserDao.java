package com.mapper;

import com.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserDAO继承基类
 */
@Mapper
public interface UserDao  {

    User selectByPrimaryKey(String id);
}