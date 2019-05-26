package com.assignment.xebia.dao.employee;

import java.util.List;

import com.assignment.xebia.model.Employee;

public interface IEmployeeDAO {
	
	 boolean register(Employee employee);
	 
	 List<Employee> getAll();
}
