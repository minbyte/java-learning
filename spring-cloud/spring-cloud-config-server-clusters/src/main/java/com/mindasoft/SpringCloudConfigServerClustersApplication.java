package com.mindasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerClustersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerClustersApplication.class, args);
	}
}