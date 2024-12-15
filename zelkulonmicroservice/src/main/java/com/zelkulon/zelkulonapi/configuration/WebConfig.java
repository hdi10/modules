package com.zelkulon.zelkulonapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:8080",
                        "http://localhost:3000",
                        "https://www.zelkulon.com", // Hauptdomain
                        "https://new-homepage-e1db173cf8f1.herokuapp.com",
                        "https://zelkulonmicroservice-myproject-1df345e27274.herokuapp.com"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // OPTIONS hinzufügen
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
