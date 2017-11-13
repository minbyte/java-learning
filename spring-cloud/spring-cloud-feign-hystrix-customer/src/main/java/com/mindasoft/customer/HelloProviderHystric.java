package com.mindasoft.customer;

import org.springframework.stereotype.Component;

/**
 * Created by huangmin on 2017/11/10 17:59.
 */
@Component
public class HelloProviderHystric implements HelloProvider{

	@Override
	public String provider() {
		return "hi,sorry,customerError!";
	}
}
