package com.jf.exam.controller;

import com.jf.exam.model.UserLoginModel;
import com.jf.exam.pojo.User;
import com.jf.exam.service.UserService;
import com.jf.exam.utils.JwtUtils;
import com.jf.exam.vo.CommResult;
import com.jf.exam.vo.JwtUserInfo;
import com.jf.exam.vo.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@Api("用户管理")
public class UserController extends BaseController {
    @Resource
    private UserService userService;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value ="/finduser", method = {RequestMethod.GET}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="通过id寻找用户")
    public User findUser(@RequestParam(value = "id") Long id){
        log.error("testlog");
       JwtUserInfo u = GetUserInfo();
        return userService.findById(id);
    }

    @RequestMapping(value ="/login", method = {RequestMethod.POST})
    @ApiOperation(value="用户登录")
    public CommResult login(@RequestBody UserLoginModel user){
        CommResult result =new CommResult();
        if (user==null|| StringUtils.isEmpty(user.getAccount())||StringUtils.isEmpty(user.getPassword()) ){
            result.setMsg("请输入账号和密码");
            return result;
        }
        //校验用户是否存在或者密码是否正确
        CommResult<User> ckResult =userService.userLogin(user.getAccount(),user.getPassword());
        if (ckResult.getCode()!= ResultCode.success){
            return ckResult;
        }
        //生成token返回
        String token = JwtUtils.geneJsonWebToken(new JwtUserInfo(ckResult.getData().getId(),ckResult.getData().getName()));
        return new CommResult(ResultCode.success,"获取token成功",token);
    }
}
