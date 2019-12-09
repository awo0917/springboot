package com.lzl.platform.result;




import com.lzl.platform.exception.Message;
import lombok.Data;

import java.io.Serializable;

/**
 *  on 2018/1/15
 * 统一返回结果
 * @author awo
 */
@Data
public class Result<T>  implements Serializable {

    private static final long serialVersionUID = -6998389175825829723L;

    /**
     * 返回数据
     */
    private T data;
    /**
     * 返回code
     */
    private String code;
    /**
     * 返回提示信息
     */
    private String msg;

    /**
     * 执行结果
     */
    private boolean success;

    public Result() {
    }

    /**
     * 执行成功
     * @param data
     */
    public Result(T data) {
        this.code = Message.M0001;
        this.msg = "操作成功";
        this.success = true;
        this.data = data;
    }

    /**
     * 执行，发生异常
     */
    public Result(String code , String msg) {
        this.code =code;
        this.msg = msg;
        if(msg == null || msg == ""){
            this.msg =  Message.E5000;
        }
        this.success = false;
    }


}
