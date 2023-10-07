package com.example.demo.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;


@Configuration
public class EmployeeData {
	
	/*Attributes*/
	private Logger logger=LoggerFactory.getLogger(EmployeeData.class);
	
	@Bean
	public CommandLineRunner InitDatabase(EmployeeRepository repository) {
		return args ->{
			logger.info("Preloading database with "+repository.save(
					new Employee("John Doe","CEO","johndoe@example.com")));
			logger.info("Preloading database with "+repository.save(
					new Employee("Jane Doe","CTO","janedoe@example.com")));
		};
	}
}
