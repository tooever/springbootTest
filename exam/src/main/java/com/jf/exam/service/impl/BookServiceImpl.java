package com.jf.exam.service.impl;

import com.jf.exam.config.MyMapper;
import com.jf.exam.mapper.BookMapper;
import com.jf.exam.pojo.Book;
import com.jf.exam.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl extends  BaseServiceImpl<Book> implements BookService {
    @Resource
    private BookMapper mapper;

    public List<Book> selectbysql(String name){
        return mapper.selectbysql(name);
    }
}
