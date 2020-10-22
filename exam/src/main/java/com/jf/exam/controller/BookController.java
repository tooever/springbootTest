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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value ="/booklist", method = {RequestMethod.GET}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="通过所有的数据")
    public CommResult booklist(@RequestParam(value = "pageindex") Integer pageindex){
        BaseExample example = new BaseExample(Book.class,pageindex,5);
        example.createCriteria().andEqualTo("name","23");
        PageInfo<Book> data= bookService.selectPageInfo(example);
//        for (Book  book: data ) {
//           Integer t= bookService.delete(book);
//            log.error("删除 "+t.toString());
//        }

        return new CommResult(ResultCode.success,"获取用户列表信息成功",data);
    }
}
