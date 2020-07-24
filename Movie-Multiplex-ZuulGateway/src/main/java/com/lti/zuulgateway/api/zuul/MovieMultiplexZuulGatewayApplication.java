package com.lti.zuulgateway.api.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MovieMultiplexZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieMultiplexZuulGatewayApplication.class, args);
	}

}
