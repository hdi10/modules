package com.zelkulon.apigateway.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Für alle Endpunkte gültig
                .allowedOrigins(
                        "http://localhost:8080",
                        "http://localhost:3000",
                        "https://new-homepage-e1db173cf8f1.herokuapp.com", // Heroku Frontend
                        "https://www.zelkulon.com" // Vercel Frontend
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Alle relevanten Methoden erlauben
                .allowedHeaders("*") // Alle Header erlauben
                .allowCredentials(true); // Cookies/Tokens erlauben
    }
}
