package com.jf.exam.controller;

import com.github.pagehelper.PageInfo;
import com.jf.exam.pojo.Book;
import com.jf.exam.pojo.User;
import com.jf.exam.service.BookService;
import com.jf.exam.utils.BaseExample;
import com.jf.exam.vo.CommResult;
import com.jf.exam.vo.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
@Api("demo管理")
public class BookController extends BaseController {

    @Resource
    private BookService bookService;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/booktest", method = {RequestMethod.GET}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "通过所有的数据")
    public CommResult booklist(@RequestParam(value = "pageindex") Integer pageindex) {
        BaseExample example = new BaseExample(Book.class, pageindex, 5);
        example.createCriteria().andEqualTo("name", "23");
        PageInfo<Book> data = bookService.selectPageInfo(example);
//        for (Book  book: data ) {
//           Integer t= bookService.delete(book);
//            log.error("删除 "+t.toString());
//        }

        Example example2 = new Example(Book.class);
        example.createCriteria().andEqualTo("name", "23");
        List<Book> data2 = bookService.selectByExample(example2);
        Book b = new Book();
        b.setName("想吃啥");
        b.setTitle("ads12");
        List<Book> data3 = bookService.selectbysql("23");
        return new CommResult(ResultCode.success, "获取用户列表信息成功", data3);
    }


    @RequestMapping(value = "/BookDetails", method = {RequestMethod.GET}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "通过所有的数据")
    public CommResult getBookDetails(@RequestParam(value = "id") Long  id) {
        Example example = new Example(Book.class);
        example.createCriteria().andEqualTo("id", id);
        Book book = bookService.selectByPrimaryKey(id);

        return new CommResult(ResultCode.success, "获取用户信息成功", book);
    }

    @RequestMapping(value = "/booklist", method = {RequestMethod.GET}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "通过所有的数据")
    public CommResult getBookList(@RequestParam(value = "pageindex") Integer pageindex, @RequestParam(value = "pagesize") Integer pagesize) {

        BaseExample example = new BaseExample(Book.class, pageindex, pagesize);
        PageInfo<Book> data = bookService.selectPageInfo(example);

        return new CommResult(ResultCode.success, "获取用户列表信息成功", data);
    }

    @RequestMapping(value = "/book.do", method = {RequestMethod.DELETE}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "通过所有的数据")
    public CommResult deletebook(@RequestParam(value = "id") Integer id) {

        Example example = new Example(Book.class);
        example.createCriteria().andEqualTo("id", id);
        Book book = bookService.selectOneByExample(example);
        if (book != null) {
            boolean ret = bookService.delete(book) > 0;
            return new CommResult(ResultCode.success, "获取用户列表信息成功", ret);
        } else {
            return new CommResult(ResultCode.error, "用户不存在", null);
        }
    }

    @RequestMapping(value = "/bookadd", method = {RequestMethod.POST}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "通过所有的数据")
    public CommResult addbook(@RequestBody Book book) {

        Example example = new Example(Book.class);
        example.createCriteria().andEqualTo("name", book.getName());
        Book bk = bookService.selectOneByExample(example);
        if (bk != null) {
            return new CommResult(ResultCode.error, "名字重复", false);
        } else {
            boolean ret = bookService.insert(book) > 0;
            return new CommResult(ResultCode.success, "添加用户列表信息成功", ret);

        }
    }

    @RequestMapping(value = "/bookaup", method = {RequestMethod.POST}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "通过所有的数据")
    public CommResult updatebook(@RequestBody Book book) {
        Example example = new Example(Book.class);
        example.createCriteria().andEqualTo("id", book.getId());
        Book bk = bookService.selectOneByExample(example);
        if (bk != null) {
            boolean ret = bookService.updateByPrimaryKey(book) > 0;
            return new CommResult(ResultCode.success, "更新用户列表信息成功", ret);
        } else {
            return new CommResult(ResultCode.error, "用户不存在", null);
        }
    }
}
