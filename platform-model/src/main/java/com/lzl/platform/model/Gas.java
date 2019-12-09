package com.lzl.platform.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Create by awo
 * @date: 2019/11/19
 * @Discription: 加油列表
 **/
@Data
public class Gas implements Serializable {

    private Integer id;

    private String name;

    private String gasId;

    private String address;

    private Double lon;

    private Double lat;

    private String provinceName;

    private String cityName;

    private String icon;

    private Long created;

    private Long updated;

    private Boolean del;
}
