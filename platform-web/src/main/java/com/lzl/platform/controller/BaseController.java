package com.lzl.platform.controller;

import com.lzl.platform.exception.Message;
import com.lzl.platform.result.Result;

/**
 * @author: Create by awo
 * @date: 2019/12/7
 * @Discription:
 **/
public class BaseController {

    /**
     * 生成结果对象
     *
     * @param data 数据
     * @return 结果
     */
    protected Result result(Object data) {
        return new Result(data);
    }

    /**
     * 返回错误结果
     *
     * @return 结果
     */
    protected Result error(String msg) {
        return new Result(Message.E5000, msg);
    }
}
