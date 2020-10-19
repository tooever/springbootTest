package com.jf.exam.controller;


import com.jf.exam.utils.JwtUtils;
import com.jf.exam.vo.JwtUserInfo;
import io.jsonwebtoken.Claims;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;

public class BaseController {
    public JwtUserInfo GetUserInfo(){
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String token = request.getHeader("Authorization");
            Claims claims = JwtUtils.checkJWT(token.replace("Bearer ",""));
            if (claims==null){
                return null;
            }
            return new JwtUserInfo(Long.parseLong(claims.get("id").toString()),claims.get("name").toString()) ;
        }
        catch (Exception ex){
             return null;
        }
    }
}
