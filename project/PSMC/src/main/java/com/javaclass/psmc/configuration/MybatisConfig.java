package com.javaclass.psmc.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.javaclass.psmc",annotationClass = Mapper.class)
public class MybatisConfig {
}
