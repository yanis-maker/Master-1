package com.example.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages={
		"com.example.demo.models"
		
}) 
@EnableJpaRepositories(basePackages={
		"com.example.demo.repositories"
})

@SpringBootApplication(scanBasePackages= {
		"com.example.demo.data",
		"com.example.demo.controllers",
		"come.example.demo.exception"
})
public class EmployeeRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApplication.class, args);
	}

}
