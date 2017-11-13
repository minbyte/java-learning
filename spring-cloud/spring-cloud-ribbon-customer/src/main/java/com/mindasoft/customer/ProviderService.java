package com.mindasoft.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huangmin on 2017/11/10 17:40.
 */
@Service
public class ProviderService {

	@Autowired
	private RestTemplate restTemplate; // HTTP 访问操作类

	public String customer() {
		String providerMsg = restTemplate.getForEntity("http://PROVIDER-SERVICE/provider",
				String.class).getBody();

		return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
	}
}
