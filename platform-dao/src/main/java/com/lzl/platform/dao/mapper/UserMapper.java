package com.lzl.platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzl.platform.model.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @author: Create by awo
 * @date: 2019/12/16
 * @Discription:
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

   /* @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "phone",column = "phone"),
    })
    @Select("select id,user_name,password,phone,created,updated from user where user_name like #{username} and password like #{password} limit 1")
    User get(@Param("username") String username, @Param("password") String password);*/
}
