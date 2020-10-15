package com.jf.exam.controller;

import com.jf.exam.pojo.User;
import com.jf.exam.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api("用户管理")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value ="/finduser", method = {RequestMethod.GET}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="通过id寻找用户")
    public User findUser(@RequestParam(value = "id") Long id){
        return userService.findById(id);
    }
}
