package com.assignment.xebia.dao.employee;

import java.util.List;

import com.assignment.xebia.model.Employee;

/**
 * 
 * @author YU296490
 * Contains method definitions for Employee DAO operations
 */
public interface IEmployeeDAO {
	
	/**
	 * 
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
