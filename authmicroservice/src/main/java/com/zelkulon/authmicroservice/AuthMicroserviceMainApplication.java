package com.zelkulon.authmicroservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthMicroserviceMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthMicroserviceMainApplication.class, args);
	}


	@RestController
	class ServiceInstanceRestController {

		@Autowired(required = false) //TODO: remove this
		private DiscoveryClient discoveryClient;

		@RequestMapping("/service-instances/{applicationName}")
		public List<ServiceInstance> serviceInstancesByApplicationName(
				@PathVariable String applicationName) {
			return this.discoveryClient.getInstances(applicationName);
		}

	}
}
