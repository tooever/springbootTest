package com.jf.exam.vo;

public interface ResultCode{
    //成功
    int success=10000;
    //操作失败
    int error=0;
    //认证失败
    int authenticationFailed = 10001;
    //授权过期
    int authenticationTimeOut = 10002;
    //参数不符合规范
    int paramVerificationFailed = 10003;
    //异常错误
    int exceptionError = 50003;
}