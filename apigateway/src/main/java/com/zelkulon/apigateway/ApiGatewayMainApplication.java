package com.zelkulon.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayMainApplication {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("zelkulonmicroservice1", r -> r.path("/blogs/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://ZELKULONMICROSERVICE"))
				.route("authservice1", r -> r.path("/auth/**")
						.filters(f -> f.stripPrefix(1))
						.uri("lb://AUTH-SERVICE"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayMainApplication.class, args);
	}

}
