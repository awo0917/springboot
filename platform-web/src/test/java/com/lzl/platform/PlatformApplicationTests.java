package com.lzl.platform;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.platform.model.domain.User;
import com.lzl.platform.model.req.QueryUserReq;
import com.lzl.platform.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlatformApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void listPageTest() {
        QueryUserReq req = new QueryUserReq();
        Page<User> userPage = userService.listByPage(req);
        JSON.toJSONString(userPage);
    }

}
