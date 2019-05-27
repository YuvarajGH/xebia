package com.assignment.xebia.model;

import java.util.Date;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.assignment.xebia.constants.Department;
import com.assignment.xebia.constants.Gender;

/**
 * 
 * @author YU296490
 * Employee entity
 */

public class Employee implements Comparable<Employee>{
	
	@NotNull(message="firstName field is mandatory")
	@Size(min=3, max=50, message="size must be between 3 and 50")
	private String firstName;
	
	
	@NotNull(message="lastName field is mandatory")
	@Size(min=3, max=50, message="size must be between 3 and 50")
	private String lastName;
	
	@NotNull(message="gender field is missing or invalid")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
	@NotNull(message="dob field is mandatory")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	
	@NotNull(message="department field is missing or invalid")
	@Enumerated(EnumType.STRING)
	private Department department;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, Gender gender, Date dob, Department department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.department = department;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int compareTo(Employee arg0) {
		return this.firstName.compareToIgnoreCase(arg0.firstName);
	}
	
	public String toString() {
		return "[ firstName="+firstName+", lastName="+lastName+", gender="+gender+", dob="+ dob +", department=" + department +" ]";
	}
	
}

