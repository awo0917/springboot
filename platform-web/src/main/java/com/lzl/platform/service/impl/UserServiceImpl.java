package com.lzl.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.platform.dao.mapper.UserMapper;
import com.lzl.platform.exception.Message;
import com.lzl.platform.exception.PlatformException;
import com.lzl.platform.model.domain.User;
import com.lzl.platform.model.req.QueryUserReq;
import com.lzl.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author: Create by awo
 * @date: 2019/12/16
 * @Discription:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String userName, String password) {

        if (StringUtils.isEmpty(userName)) {
            throw new PlatformException(Message.E5000,"用户名不能为空");
        }

        if (StringUtils.isEmpty(password)) {
            throw new PlatformException(Message.E5000,"密码不能为空");
        }

        User user = userMapper.selectOne(
                new QueryWrapper<User>().lambda()
                        .eq(User::getUserName,userName)
                        .eq(User::getPassword,password)
                        .select(User::getId,User::getUserName,User::getPhone));

        if (user == null) {
            throw new PlatformException(Message.E5000,"用户名或密码错误");
        }

        return user;
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public Page<User> listByPage(QueryUserReq req) {

        Page<User> page = new Page(req.getPageNum(),req.getPageSize());

        Page<User> result = userMapper.selectPage(page,
                Wrappers.<User>lambdaQuery().orderByDesc(User::getCreated));

        return result;
    }
}
