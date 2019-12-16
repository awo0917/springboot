package com.lzl.platform.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzl.platform.model.domain.User;
import com.lzl.platform.model.req.QueryUserReq;

/**
 * @author: Create by awo
 * @date: 2019/12/16
 * @Discription: 用户模块
 * 1. 继承IService，它实现了crud的基本操作
 * 2. 在具体的service方法中做前置校验
 * 3. 部分不满足条件的方法（如：多表操作）则使用customerMapper实现
 **/
public interface UserService extends IBaseService<User> {

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
