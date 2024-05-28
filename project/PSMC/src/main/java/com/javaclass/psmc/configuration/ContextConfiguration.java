package com.javaclass.psmc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@ComponentScan(basePackages = "com.javaclass.psmc")
public class ContextConfiguration {

    @Bean
    MappingJackson2JsonView jasonView(){
        return new MappingJackson2JsonView();
    }


}
