package com.jf.exam.service.impl;

import com.jf.exam.mapper.UserMapper;
import com.jf.exam.pojo.User;
import com.jf.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(long id){
        return userMapper.findById(id);
    }
}
