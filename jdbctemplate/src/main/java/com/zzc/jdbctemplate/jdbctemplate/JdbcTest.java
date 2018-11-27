package com.zzc.jdbctemplate.jdbctemplate;

import dal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-26 11:51
 * Description:
 *
 * spring JdbcTemplate 是从 连接池中获取连接的，所以必须先配置数据库连接池。
 *
 **/
@Component
public class JdbcTest {

    @Autowired
    JdbcTemplate jdbcTemplate ;

    public String get(){
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        String sql = "select * from  user ";
        List<User> results = jdbcTemplate.query(sql,rowMapper);
        return results.get(0).toString();
    }


}
