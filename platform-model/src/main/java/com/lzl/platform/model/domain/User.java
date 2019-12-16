package com.lzl.platform.model.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -8935330023965167990L;

    private Integer id;

    private String userName;

    private String password;

    private String phone;

    private Long created;

    private Long updated;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}