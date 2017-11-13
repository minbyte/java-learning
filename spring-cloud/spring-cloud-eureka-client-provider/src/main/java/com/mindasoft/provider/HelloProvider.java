package com.mindasoft.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huangmin on 2017/11/10 14:30.
 */
@RestController
public class HelloProvider {

	private static final Logger logger = LoggerFactory.getLogger(HelloProvider.class);

	@Value("${server.port}")
	private String port;

	@Autowired
	private Registration registration;       // 服务注册

	@Autowired
	private DiscoveryClient discoveryClient; // 服务发现客户端

	@RequestMapping("/provider")
	public String provider() {
		ServiceInstance instance = serviceInstance();
		logger.info("provider service, host = " + instance.getHost()
				+ ", service_id = " + instance.getServiceId());
		return "Hello,Provider!from port:"+ port;
	}

	/**
	 * 获取当前服务的服务实例
	 *
	 * @return ServiceInstance
	 */
	public ServiceInstance serviceInstance() {
		List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
