package com.jf.exam.service.impl;

import com.jf.exam.pojo.Book;
import com.jf.exam.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl extends  BaseServiceImpl<Book> implements BookService {
}
