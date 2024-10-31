package com.MukundLearning.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MukundLearning.restapi.repository.EmployeeRepository;
import com.MukundLearning.restapi.entity.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		List<Employee> employees = repo.findAll();
		return employees;
	}
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		Employee employee = repo.findById(id).get();
		return employee;
	}
	
	@PostMapping("/employee/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createEmployee(@RequestBody Employee employee)
	{
		repo.save(employee);
	}
	
	@PutMapping("/employee/update/{id}")
	public Employee updateEmployee(@PathVariable int id)
	{
		Employee employee = repo.findById(id).get();
		employee.setName("Poonam");
		employee.setSalary(7800);
		employee.setDepartment("Cloud");
		repo.save(employee);
		return employee;
	}
	
	@DeleteMapping("employee/delete/{id}")
	public void removeEmployee(@PathVariable int id)
	{
		Employee employee = repo.findById(id).get();
		repo.delete(employee);
	}

}
