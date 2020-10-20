package com.jf.exam.service;

import com.jf.exam.pojo.User;
import com.jf.exam.vo.CommResult;

import java.util.List;

public interface UserService {
    public User findById(long id);
    public CommResult userLogin(String account, String PassWord);

    public List<User> findUserList();
}
