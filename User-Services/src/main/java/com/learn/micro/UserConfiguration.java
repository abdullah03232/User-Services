package com.learn.micro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfiguration {

	@Bean
	RestTemplate userServiceRestTemplate() {
		return new RestTemplate();
	}

}
