package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	/*ATTRIBUTES*/
	
	@Autowired
	private EmployeeRepository repository;
	private static final String uri="employeeservice/api";
	
	
	/*METHODS*/
	@GetMapping(uri+"/employees")
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
	
	
	@GetMapping(uri+"/employees/count")
	public String count() {
		return String.format("{\"%s\" : %s}", "count", repository.count());
	}
	
	@GetMapping(uri+"/employees/{id}")
	public Employee getEmployeeById(@PathVariable long id) throws EmployeeNotFoundException {
		return repository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException(
						"Error : Could not fint employee with id : "+id));
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@PutMapping(uri+"/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable long id) {
		return repository.findById(id)
				.map(employee->{
					employee.setName(newEmployee.getName());
					employee.setEmail(newEmployee.getEmail());
					employee.setRole(newEmployee.getRole());
					return employee;
				}).orElseGet(() ->{
					newEmployee.setId(id);
					repository.save(newEmployee);
					return newEmployee;
				});
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(uri+"/employees/{id}")
	public void deleteEmployee(@PathVariable long id) throws EmployeeNotFoundException {
		Employee employee =repository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException(
						"Error : Could not fint employee with id : "+id));
		repository.delete(employee);
	}
}
