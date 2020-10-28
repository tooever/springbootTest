package com.jf.exam.mapper;

import com.jf.exam.config.MyMapper;
import com.jf.exam.pojo.User;
import com.jf.exam.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    UserVo getUserRole(@Param("id")Integer id);
}