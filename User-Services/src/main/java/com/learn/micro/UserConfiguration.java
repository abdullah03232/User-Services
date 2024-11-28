package com.learn.micro;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfiguration {

	@Bean
	@LoadBalanced
	RestTemplate userServiceRestTemplate() {
		return new RestTemplate();
	}

}
