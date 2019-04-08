package com.mindasoft.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ImportResource({"classpath:xxx.xml",""})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
