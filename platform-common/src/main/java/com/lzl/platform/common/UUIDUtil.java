package com.lzl.platform.common;

import java.util.UUID;

/**
 *  on 2018/6/21
 * 生成唯一标示
 * @author linggan
 */
public class UUIDUtil {


    public final static String get(Object... key){

        StringBuffer sb = new StringBuffer();
        for(Object str : key){
            sb.append(str);
        }

        sb.append(UUID.randomUUID().toString());

        return Md5Util.md5To16(sb.toString());
    }
}
