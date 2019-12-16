package com.lzl.platform.model.req;

import com.lzl.platform.model.base.PageModel;
import lombok.Data;

/**
 * @author: Create by awo
 * @date: 2019/12/16
 * @Discription:
 **/
@Data
public class QueryUserReq extends PageModel {

    private String userName;
}
