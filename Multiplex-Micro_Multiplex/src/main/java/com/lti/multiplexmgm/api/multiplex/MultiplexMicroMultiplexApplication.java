package com.lti.multiplexmgm.api.multiplex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MultiplexMicroMultiplexApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplexMicroMultiplexApplication.class, args);
		
		System.out.println("Started Multiplex Service");
	}

}
