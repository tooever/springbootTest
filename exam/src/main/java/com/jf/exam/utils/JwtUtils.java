package com.jf.exam.utils;

import com.alibaba.druid.util.StringUtils;
import com.jf.exam.vo.JwtUserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    public static final String SUBJECT = "admin";

    /**
     * 过期时间，毫秒，一周
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    /**
     * 秘钥
     */
    public static final String APPSECRET = "haitaiinc";

    /**
     * 生成jwt
     *
     * @param userInfo
     * @return
     */
    public static String geneJsonWebToken(JwtUserInfo userInfo) {

        if (userInfo == null || userInfo.getId()==0 || StringUtils.isEmpty(userInfo.getName())) {
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", userInfo.getId())
                .claim("name", userInfo.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();

        return token;
    }


    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {

        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return claims;

        } catch (Exception e) {
        }
        return null;
    }
}
