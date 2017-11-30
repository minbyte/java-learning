package com.mindasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 相关工程：spring-cloud-eureka-server、spring-cloud-config-server-clusters
 * 配置客户端集群，使用消息的方式可以不用 重启就能重新加载配置
 * POST http://localhost:9012/bus/refresh
 */
@RefreshScope
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudConfigClientClustersBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientClustersBusApplication.class, args);
	}
}