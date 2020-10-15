package com.jf.exam.service.impl;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.jf.exam.mapper.UserMapper;
import com.jf.exam.pojo.User;
import com.jf.exam.service.UserService;
import com.jf.exam.vo.CommResult;
import com.jf.exam.vo.ResultCode;
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

    @Override
    public CommResult userLogin(String account, String passWord) {
        CommResult<User> result =new CommResult<User>();
        User user = userMapper.userLogin(account,passWord);
        if (user==null){
            result.setMsg("账号或者密码错误，请重试");
            return result;
        }

        result.setCode(ResultCode.success);
        result.setData(user);
        return result;
    }
}
