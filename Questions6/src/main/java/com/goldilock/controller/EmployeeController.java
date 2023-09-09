package com.goldilock.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goldilock.entity.Employee;
import com.goldilock.exception.EmployeeException;
import com.goldilock.repo.EmployeeRepo;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepo er;
	
	@GetMapping("/get")
	public String getAllEmployee()throws EmployeeException{
		List<Employee> emp = er.findAll();
		if(emp.isEmpty()) {
			throw new EmployeeException("No employees found on database...");
		}
		
		String output = emp.stream().map(em->"Name: "+em.getEmpName()+" Age : "+em.getEmpAge()).collect(Collectors.joining("\n"));
		return output;
	}
}
