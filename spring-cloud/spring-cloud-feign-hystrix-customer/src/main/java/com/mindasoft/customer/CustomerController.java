package com.mindasoft.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangmin on 2017/11/10 14:50.
 */
@RestController
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private HelloProvider customerService;

	@RequestMapping("/customer")
	public String customer() {
		String providerMsg = customerService.provider();
		return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
	}
}
