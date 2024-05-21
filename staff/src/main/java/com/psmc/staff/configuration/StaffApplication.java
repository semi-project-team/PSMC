package com.psmc.staff.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.psmc.staff")
@MapperScan(
        basePackages = "com.psmc.staff",
        annotationClass = Mapper.class
)
public class StaffApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffApplication.class, args);
    }

}
