package com.zzc.springbootmybatis.dal;

import com.zzc.springbootmybatis.dal.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-22 14:28
 * Description:
 **/
@Mapper
public interface UserDao {
    /**
     * xml 方式
     * @param userName
     * @return
     */
    User getUser(String userName);

    /**
     * 注解方式查询
     * @param userName
     * @return
     */
    @Select("select * from user where  username = #{userName}")
    User getUser_zhujie(String userName);

    /**
     * 注解方式更新
     * @param userName
     * @return
     */
    @Update("update user set name = 'zzc'  where  username = #{userName}")
     int updateUser(String userName);
}
