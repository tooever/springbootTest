package com.jf.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@Configuration
public class TkMapperConf {
    @Bean
    public MapperScannerConfigurer mMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.jf.exam.mapper");
        mapperScannerConfigurer.setMarkerInterface(MyMapper.class);

        Properties properties = new Properties();
        properties.setProperty("mappers", "com.jf.exam.config.MyMapper");
        properties.setProperty("notEmpty", "false");
        properties.setProperty("style", "camelhump");
        properties.setProperty("identity", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
