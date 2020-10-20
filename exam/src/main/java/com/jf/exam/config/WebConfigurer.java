package com.jf.exam.config;

import com.jf.exam.interceptor.JwtAuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authenticationInterceptor())
                //默认拦截所有路径
                .addPathPatterns("/**")
                //放行swagger相关资源
                .excludePathPatterns("/v2/**","/doc.html","/swagger-resources/**","/webjars/**","/swagger-ui.html/**","/error","/csrf","/favico*","/api-docs","swagger.json","/configuration/**")
                //放行登录接口
                .excludePathPatterns("/user/login")
                //放行静态资源
                 .excludePathPatterns("/static/**",
                "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg",
                "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg");
    }
    @Bean
    public JwtAuthenticationInterceptor authenticationInterceptor() {
        return new JwtAuthenticationInterceptor();
    }
    // 解决浏览器端跨站安全机制的问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("Authorization");
    }
}