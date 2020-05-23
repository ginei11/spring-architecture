package com.carlos.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringServiceSecurityGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceSecurityGatewayApplication.class, args);
	}

}
