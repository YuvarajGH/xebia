package com.assignment.xebia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.assignment.xebia.constants.Department;
import com.assignment.xebia.constants.Gender;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class XebiaAssignmentApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(XebiaAssignmentApplication.class, args); 
	}
	
}

 //CONVERTERS FOR ENUM

@Component
class DepertmentEnumConverter implements Converter<String, Department>{
	@Override
	public Department convert(String arg0) {
		try {
			return Department.valueOf(arg0);
	    }
		catch(Exception e) {
			return null;
		}
	}
}

@Component
class GenderEnumConverter implements Converter<String, Gender>{
	@Override
	public Gender convert(String arg0) {
		try {
			return Gender.valueOf(arg0);
	    }
		catch(Exception e) {
			return null;
		}
	}
}
