package com.jf.exam.mapper;

import com.jf.exam.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User findById(Long id);
    User userLogin(String account,String passWord);
}
