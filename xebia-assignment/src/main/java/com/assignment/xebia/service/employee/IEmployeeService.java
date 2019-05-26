package com.assignment.xebia.service.employee;

import java.util.List;

import com.assignment.xebia.model.Employee;

public interface IEmployeeService {
	
	 boolean register(Employee employee);
	 
	 List<Employee> getAll();
}
