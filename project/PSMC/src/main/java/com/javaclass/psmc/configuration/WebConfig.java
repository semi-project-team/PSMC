package com.javaclass.psmc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/common/")
                .addResourceLocations("file:///common/postimg");
        registry.addResourceHandler("/images/postimg/**")
                .addResourceLocations("file:"+uploadDir+"/");
        registry.addResourceHandler("/images/employeeimg/**")
                .addResourceLocations("file:"+uploadDir+"/");
    }

}
