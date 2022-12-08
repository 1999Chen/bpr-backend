package com.shaoyu.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:4200");

        registry.addMapping("/**").allowedHeaders("Content-Type", "application/json");
        registry.addMapping("/**").allowedHeaders("Access-Control-Allow-Credentials", "true");
        registry.addMapping("/**").allowedHeaders("Access-Control-Allow-Methods", "GET, POST, PATCH, DELETE, PUT, OPTIONS");
        registry.addMapping("/**").allowedHeaders("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        registry.addMapping("/**").allowedHeaders("Access-Control-Allow-Origin", "*");

    }
}
