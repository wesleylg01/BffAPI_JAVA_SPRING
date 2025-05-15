package com.wgluciano.bffapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BffapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffapiApplication.class, args);
	}

}
