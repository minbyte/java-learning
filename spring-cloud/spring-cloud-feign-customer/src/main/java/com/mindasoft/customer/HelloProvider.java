package com.mindasoft.customer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huangmin on 2017/11/10 15:45.
 */
@FeignClient(value = "provider-service")
public interface HelloProvider {

	@RequestMapping(value = "/provider",method = RequestMethod.GET)
	String provider();
}
