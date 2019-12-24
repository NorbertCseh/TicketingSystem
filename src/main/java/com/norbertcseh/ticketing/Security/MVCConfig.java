package com.norbertcseh.ticketing.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * MVCConfig
 */
@Configuration
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurationSupport {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**").allowedOrigins("*");
    }
}