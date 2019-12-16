package com.lzl.platform.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.platform.model.domain.User;
import com.lzl.platform.model.req.QueryUserReq;

/**
 * @author: Create by awo
 * @date: 2019/12/16
 * @Discription: 用户模块
 **/
public interface UserService {

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    User getUser(String userName,String password);

    /**
     * 用户注册
     * @param user
     */
    void add(User user);

    /**
     * 用户更新
     * @param user
     */
    void update(User user);

    /**
     * 分页查询
     * @return
     */
    Page<User> listByPage(QueryUserReq req);
}
