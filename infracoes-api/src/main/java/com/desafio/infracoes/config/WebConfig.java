package com.desafio.infracoes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {


//    final String FRONTEND_URL = Constants.FRONTEND_URL;
    final String CORS_METHODS = Constants.CORS_METHODS;
    final String CORS_ALLOW_HEADERS = Constants.CORS_ALLOW_HEADERS;
    final boolean CORS_ALLOW_CREDENTIALS = Constants.CORS_ALLOW_CREDENTIALS;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods(CORS_METHODS)
                .allowedHeaders(CORS_ALLOW_HEADERS)
                .allowCredentials(CORS_ALLOW_CREDENTIALS)
                .maxAge(3600);
    }

}
