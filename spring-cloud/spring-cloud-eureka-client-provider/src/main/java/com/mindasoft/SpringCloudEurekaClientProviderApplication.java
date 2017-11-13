package com.mindasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient     // Eureka Client 标识
@SpringBootApplication
public class SpringCloudEurekaClientProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaClientProviderApplication.class, args);
	}
}
