package com.jf.exam.service;

import com.jf.exam.pojo.User;
import com.jf.exam.vo.CommResult;
import com.jf.exam.vo.UserVo;

import java.util.List;

public interface UserService  extends  BaseService<User>{

        public CommResult userLogin(String account, String PassWord);

        public UserVo GetUserRole(Integer id);

}
