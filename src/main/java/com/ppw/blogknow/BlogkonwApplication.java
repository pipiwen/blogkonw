package com.ppw.blogknow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(exclude = { JacksonAutoConfiguration.class })
@MapperScan(basePackages = "com.ppw.blogknow.*dao")
public class BlogkonwApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BlogkonwApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BlogkonwApplication.class);
    }

}
