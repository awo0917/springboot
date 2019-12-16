package com.lzl.platform.model.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Create by awo
 * @date: 2019/12/16
 * @Discription:
 **/
@Data
public class PageModel<T> extends BaseModel implements Serializable {

    private int pageSize = 10;

    private int pageNum = 1;
}
