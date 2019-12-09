package com.lzl.platform.common;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *  on 2018/5/30
 * @author linggan
 */
public class Md5Util {

    /**
     * md5 16位
     *
     * @param str
     * @return
     */
    public final static String md5To16(String str) {

        String md5 = DigestUtils.md2Hex(str);

        return md5.substring(8, 24);

    }


    /**
     * md5 16位 转大写
     *
     * @param str
     * @return
     */
    public final static String md5To16Lowercase(String str) {

        return md5To16(str).toUpperCase();

    }



    /**
     * 生成唯一字符串
     *
     * @param key
     * @return
     */
    public final static String getToken(Object... key) {

        return UUIDUtil.get(key);
    }

}
