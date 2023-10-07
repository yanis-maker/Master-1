package com.example.demo.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component 
public class EmployeeServiceClient {
	
	@Bean
	public RestTemplate genrateRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
