package com.jf.exam;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jf.exam"})
@MapperScan("com.jf.exam.mapper")
public class ExamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }
}
