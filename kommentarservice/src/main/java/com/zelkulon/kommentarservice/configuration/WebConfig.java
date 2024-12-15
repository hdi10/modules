package com.zelkulon.kommentarservice.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/kommentare")
                        .allowedOrigins("http://localhost:3000") // URL deines Frontends
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
