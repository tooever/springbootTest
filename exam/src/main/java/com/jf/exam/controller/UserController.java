package com.jf.exam.controller;

import com.github.pagehelper.PageInfo;
import com.jf.exam.model.UserLoginModel;
import com.jf.exam.pojo.User;
import com.jf.exam.service.UserService;
import com.jf.exam.utils.BaseExample;
import com.jf.exam.utils.JwtUtils;
import com.jf.exam.vo.CommResult;
import com.jf.exam.vo.JwtUserInfo;
import com.jf.exam.vo.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api("用户管理")
public class UserController extends BaseController {
    @Resource
    private UserService userService;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value ="/finduser", method = {RequestMethod.GET}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="通过id寻找用户")
    public CommResult findUser(@RequestParam(value = "id") Long id){
        log.error("testlog");
       JwtUserInfo u = GetUserInfo();
        User data= userService.selectByPrimaryKey(id);
        return new CommResult(ResultCode.success,"获取用户信息成功",data);
    }

    @RequestMapping(value ="/login", method = {RequestMethod.POST})
    @ApiOperation(value="用户登录")
    public CommResult login(@RequestBody UserLoginModel logininfo){
        CommResult result =new CommResult();
        if (logininfo==null|| StringUtils.isEmpty(logininfo.getUsername())||StringUtils.isEmpty(logininfo.getPassword()) ){
            result.setMsg("请输入账号和密码");
            return result;
        }
        //校验用户是否存在或者密码是否正确
        CommResult<User> ckResult =userService.userLogin(logininfo.getUsername(),logininfo.getPassword());
        if (ckResult.getCode()!= ResultCode.success){
            return ckResult;
        }
        //生成token返回
        String token = JwtUtils.geneJsonWebToken(new JwtUserInfo(ckResult.getData().getId(),ckResult.getData().getUsername()));
        return new CommResult(ResultCode.success,"获取token成功",token);
    }

    @RequestMapping(value = "/userlist", method = {RequestMethod.GET}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "分页获取用户的数据")
    public CommResult getBookList(@RequestParam(value = "pageindex") Integer pageindex, @RequestParam(value = "pagesize") Integer pagesize) {

        BaseExample example = new BaseExample(User.class, pageindex, pagesize);
        PageInfo<User> data = userService.selectPageInfo(example);

        return new CommResult(ResultCode.success, "获取用户列表信息成功", data);
    }

    @RequestMapping(value = "/userDetails", method = {RequestMethod.GET}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取用户信息详情")
    public CommResult getBookDetails(@RequestParam(value = "id") Long  id) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", id);
        User book = userService.selectByPrimaryKey(id);
        return new CommResult(ResultCode.success, "获取用户信息成功", book);
    }

    @RequestMapping(value = "/userdel", method = {RequestMethod.DELETE}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "删除用户信息")
    public CommResult deletebook(@RequestParam(value = "id") Integer id) {

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", id);
        User user = userService.selectOneByExample(example);
        if (user != null) {
            boolean ret = userService.delete(user) > 0;
            if(ret)
            {
                return new CommResult(ResultCode.success, "删除用户信息成功", true);
            }
            else
            {
                return new CommResult(ResultCode.success, "删除用户信息失败", false);
            }
        } else {
            return new CommResult(ResultCode.error, "删除失败，用户信息不存在", null);
        }
    }

    @RequestMapping(value = "/useradd", method = {RequestMethod.POST}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "添加用户信息")
    public CommResult addbook(@RequestBody User user) {

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", user.getUsername());
        User us = userService.selectOneByExample(example);
        if (us != null) {
            return new CommResult(ResultCode.error, "用户名已存在,不能重复添加", false);
        } else {
            boolean ret = userService.insert(user) > 0;
            if(ret)
            {
                return new CommResult(ResultCode.success, "添加用户信息成功", true);
            }
            else
            {
                return new CommResult(ResultCode.success, "添加用户信息失败", false);
            }
        }
    }

    @RequestMapping(value = "/userup", method = {RequestMethod.POST}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "更新用户信息")
    public CommResult updatebook(@RequestBody User user) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id", user.getId());
        User us = userService.selectOneByExample(example);
        if (us != null) {
            boolean ret = userService.updateByPrimaryKey(user) > 0;
            if(ret)
            {
                return new CommResult(ResultCode.success, "更新用户信息成功", true);
            }
            else
            {
                return new CommResult(ResultCode.success, "更新用户信息失败", false);
            }
        } else {
            return new CommResult(ResultCode.error, "更新用户信息失败,用户不存在", null);
        }
    }
}
