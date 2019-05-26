package com.assignment.xebia.service.employee;

import java.util.List;

import com.assignment.xebia.model.Employee;

/**
 * 
 * @author YU296490
 * Contains method declarations for Employee service operations 
 */
public interface IEmployeeService {
	
	/**
	 * @param employee 
	 * @return boolean
	 * Creates new user 
	 */
	 boolean registerEmployee(Employee employee);
	 
	 /**
	  * @return List<Employee>
	  * Fetches all users 
	  */
	 List<Employee> getAllEmployees();
}
