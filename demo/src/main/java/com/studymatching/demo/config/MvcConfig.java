package com.studymatching.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // 요청 - 뷰 연결
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("board/list");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/detail").setViewName("board/detail");
        registry.addViewController("/list").setViewName("board/list");
        registry.addViewController("/update").setViewName("board/update");
        registry.addViewController("/write").setViewName("board/write");
    }
}
