package com.jf.exam.vo;

import java.io.Serializable;

public class JwtUserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;

    public JwtUserInfo() {
    }

    public JwtUserInfo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
