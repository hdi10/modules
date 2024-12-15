package com.zelkulon.apigateway.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedOrigins( "http://localhost:3000")
                .allowedOrigins(
                        "https://new-homepage-e1db173cf8f1.herokuapp.com"
                )
                .allowedOrigins("https://new-homepage-e1db173cf8f1.herokuapp.com/") // Ersetze durch die URL deines Frontends
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // OPTIONS hinzufügen
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

