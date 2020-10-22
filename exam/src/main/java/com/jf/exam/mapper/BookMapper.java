package com.jf.exam.mapper;

import com.jf.exam.config.MyMapper;
import com.jf.exam.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface  BookMapper extends MyMapper<Book> {
}
