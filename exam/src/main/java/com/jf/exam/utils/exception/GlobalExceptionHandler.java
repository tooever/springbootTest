package com.jf.exam.utils.exception;

import com.jf.exam.vo.CommResult;
import com.jf.exam.vo.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

@ControllerAdvice //该注解定义全局异常处理类
//@ControllerAdvice(basePackages ="com.example.demo.controller") 可指定包
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class) //该注解声明异常处理方法
    public CommResult<String> exceptionHandler(HttpServletRequest request, Exception e) {
        CommResult<String> result = new CommResult<String>();
        result.setMsg("服务器出错了");
        e.printStackTrace();

        if (e instanceof RuntimeException) {
            RuntimeException ex = (RuntimeException) e;
            //todo 后续可以改成switch
            if (ex.getMessage()== "401") {
                result.setCode(ResultCode.authenticationFailed);
                result.setMsg("授权失败");
                return result;
            }
        } else if (e instanceof BindException) {
            return result;
        } else {
            return result;
        }
        return result;
    }
}