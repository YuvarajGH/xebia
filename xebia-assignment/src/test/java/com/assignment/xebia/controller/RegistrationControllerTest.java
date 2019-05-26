package com.assignment.xebia.controller;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.assignment.xebia.constants.Department;
import com.assignment.xebia.constants.Gender;
import com.assignment.xebia.model.Employee;
import com.assignment.xebia.service.employee.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class RegistrationControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	@Test
	public void retrieveDetailsForCourse() throws Exception {
		
		Employee employee = new Employee();
		employee.setGender(Gender.MALE);
		employee.setFirstName("Yuvaraj");
		employee.setLastName("G");
		employee.setDob(new Date());
		employee.setDepartment(Department.BUSINESS);
		
		
		/*Mockito.when(
				employeeService.register(employee)).thenReturn(true);*/

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/register")
															  .contentType(MediaType.APPLICATION_FORM_URLENCODED)
															  .param("firstname", employee.getFirstName())
															  .param("lastname", employee.getLastName())
															  .param("dob", employee.getDob().toString())
															  .param("department", String.valueOf(employee.getDepartment()))
															  .param("gender", String.valueOf(employee.getGender()));
																	
															 
															  
															  
			

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		System.out.println(result.getResponse().getStatus());
		
/*		String expected = "{id:Course1,name:Spring,description:10 Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);*/

	}
}
