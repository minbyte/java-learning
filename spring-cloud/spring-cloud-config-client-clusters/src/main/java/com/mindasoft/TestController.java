package com.mindasoft;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangmin on 2017/11/13 11:55.
 */
@RestController
public class TestController {

	@Value("${foo}")
	String foo;

	@RequestMapping(value = "/hello")
	public String hi(){
		return foo;
	}
}
