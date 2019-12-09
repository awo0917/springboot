package com.lzl.platform.controller;

import com.lzl.platform.result.Result;
import com.lzl.platform.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Create by awo
 * @date: 2019/12/7
 * @Discription:
 **/
@RestController()
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public Result test() {
        demoService.doSomeThing();
        return result("success");
    }
}
