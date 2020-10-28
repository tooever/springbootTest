package com.jf.exam.service.impl;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.jf.exam.mapper.UserMapper;
import com.jf.exam.pojo.User;
import com.jf.exam.service.UserService;
import com.jf.exam.vo.CommResult;
import com.jf.exam.vo.ResultCode;
import com.jf.exam.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements  UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public CommResult userLogin(String account, String passWord) {
        CommResult<User> result =new CommResult<User>();
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", account).andEqualTo("password",passWord);
        User user = userMapper.selectOneByExample(example);
        if (user==null){
            result.setMsg("账号或者密码错误，请重试");
            return result;
        }
        result.setCode(ResultCode.success);
        result.setData(user);
        return result;
    }
    @Override
    public UserVo GetUserRole(Integer id) {
        UserVo user = userMapper.getUserRole(id);
        return user;
    }


}
