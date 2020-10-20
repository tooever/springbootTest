package com.jf.exam.interceptor;

import com.jf.exam.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        //授权请求直接放行
        if (httpServletRequest instanceof HttpServletRequest) {
            if (httpServletRequest.getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }
        }
        // 从请求头中取出 token
        String token = httpServletRequest.getHeader("Authorization");
        if (StringUtils.isEmpty(token) || !token.startsWith("Bearer")){
            httpServletResponse.setStatus(401);
            throw new RuntimeException("401");
        }

        //token有效性校验 包含格式和时效
        Claims claims = JwtUtils.checkJWT(token.replace("Bearer ",""));
        if (claims==null){
            httpServletResponse.setStatus(401);
            throw new RuntimeException("401");
        }
       if (claims.getExpiration().getTime()<=new Date().getTime()){
           httpServletResponse.setStatus(401);
           throw new RuntimeException("401");
       }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
