package com.jf.exam.service;

import com.jf.exam.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookService extends  BaseService<Book> {
    List<Book> selectbysql(String name);

}
