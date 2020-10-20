package com.jf.exam.mapper;

import com.jf.exam.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User findById(Long id);
    User userLogin(String account,String passWord);
    List<User> findUserList();
}
