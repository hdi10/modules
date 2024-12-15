package com.zelkulon.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayMainApplication {


	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayMainApplication.class, args);
	}

}
