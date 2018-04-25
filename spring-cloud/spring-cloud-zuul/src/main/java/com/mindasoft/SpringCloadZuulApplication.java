package com.mindasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy  // 开启zuul
@EnableEurekaClient
@SpringBootApplication
public class SpringCloadZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloadZuulApplication.class, args);
	}
}
