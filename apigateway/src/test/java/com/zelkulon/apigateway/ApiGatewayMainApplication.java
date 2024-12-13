package com.zelkulon.apigateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ApiGatewayMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayMainApplication.class, args);
	}

}