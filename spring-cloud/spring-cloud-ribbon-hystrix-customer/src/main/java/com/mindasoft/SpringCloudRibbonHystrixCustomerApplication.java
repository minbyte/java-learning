package com.mindasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrix // Hystrix标识
@EnableDiscoveryClient // Eureka Discovery Client 标识
@SpringBootApplication
public class SpringCloudRibbonHystrixCustomerApplication {

	@Bean
	@LoadBalanced   // 开启负载均衡的功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonHystrixCustomerApplication.class, args);
	}
}
