package com.assignment.xebia.dao.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.assignment.xebia.model.Employee;

@Repository
public class EmployeeDAO implements IEmployeeDAO {

	// SINCE THERE IS NO REQUIREMENT FOR DB, USING A SIMPLE LIST TO PERSIST THE DATA;
	private static List<Employee> EMPLOYEE_STORE = new ArrayList<Employee>();
			
	
	@Override
	public boolean registerEmployee(Employee employee) {
		return EMPLOYEE_STORE.add(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Collections.sort(EMPLOYEE_STORE);
		return EMPLOYEE_STORE;
	}

}
