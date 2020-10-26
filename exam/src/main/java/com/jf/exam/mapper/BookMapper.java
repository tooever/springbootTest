package com.jf.exam.mapper;

import com.jf.exam.config.MyMapper;
import com.jf.exam.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface  BookMapper extends MyMapper<Book> {

    @Select("select * from t_book where name= #{name}")
    List<Book> selectbysql(String name);
}
