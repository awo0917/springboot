package com.lzl.platform.controller;

import com.lzl.platform.model.req.QueryUserReq;
import com.lzl.platform.result.Result;
import com.lzl.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Create by awo
 * @date: 2019/12/16
 * @Discription:
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login/{userName}/{password}")
    public Result login(@PathVariable("userName") String name,@PathVariable("password") String password) {
        return result(userService.getUser(name,password));
    }

    @RequestMapping("/list")
    public Result list(@RequestBody QueryUserReq req) {
        return result(userService.listByPage(req));
    }
}
