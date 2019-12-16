package com.lzl.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.platform.dao.mapper.UserMapper;
import com.lzl.platform.exception.Message;
import com.lzl.platform.exception.PlatformException;
import com.lzl.platform.model.domain.User;
import com.lzl.platform.model.req.QueryUserReq;
import com.lzl.platform.service.BaseServiceImpl;
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
public class UserServiceImpl extends BaseServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String userName, String password) {

        check(new User(userName,password));

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

    private void check(User user) {

        if (user == null) {
            throw new PlatformException(Message.E5000,"【user】对象不能为空");
        }

        String userName = user.getUserName();
        String password = user.getPassword();

        if (StringUtils.isEmpty(userName)) {
            throw new PlatformException(Message.E5000,"用户名不能为空");
        }

        if (StringUtils.isEmpty(password)) {
            throw new PlatformException(Message.E5000,"密码不能为空");
        }
    }
    @Override
    public void add(User user) {
        check(user);
        user.setCreated(System.currentTimeMillis());
        user.setUpdated(System.currentTimeMillis());
        this.save(user);
    }

    @Override
    public void update(User user) {

        if (user == null) {
            throw new PlatformException(Message.E5000,"【user】对象不能为空");
        }

        if (user.getId() == null) {
            throw new PlatformException(Message.E5000,"用户id不能为空");
        }

        user.setUpdated(System.currentTimeMillis());

        this.updateById(user);
    }

    @Override
    public Page<User> listByPage(QueryUserReq req) {

        Page<User> page = new Page(req.getPageNum(),req.getPageSize());

        Page<User> result = this.page(page,
                Wrappers.<User>lambdaQuery().orderByDesc(User::getCreated));

        return result;
    }
}
