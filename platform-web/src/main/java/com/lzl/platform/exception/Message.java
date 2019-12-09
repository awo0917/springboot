package com.lzl.platform.exception;

/**
 *  on 2018/1/15
 * 错误码
 * @author linggan
 */
public interface Message {

    /**
     * 处理成功
     */
    String M0001 = "0001";

    /**
     *  系统异常
     */
    String E5000 = "5000";

    /**
     *业务参数异常
     */
    String E4000 = "4000";

    /**
     *用户信息不存在
     */
    String E4044 = "4044";

    /**
     * openID查询用户不存在
     */
    String E4045 = "4045";

}
