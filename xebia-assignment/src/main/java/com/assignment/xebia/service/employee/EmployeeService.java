package com.assignment.xebia.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.xebia.dao.employee.IEmployeeDAO;
import com.assignment.xebia.model.Employee;

@Service
public class EmployeeService implements IEmployeeService {

	
	@Autowired
	private IEmployeeDAO employeeDAO;
	
	
	@Override
	public boolean registerEmployee(Employee employee) {
		return employeeDAO.registerEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

}
