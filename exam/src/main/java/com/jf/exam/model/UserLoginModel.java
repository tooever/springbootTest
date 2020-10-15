package com.jf.exam.model;

import java.io.Serializable;

public class UserLoginModel {
    private static final long serialVersionUID = 1L;
    private String account;
    private String password;

    public UserLoginModel() {
    }

    public UserLoginModel(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
