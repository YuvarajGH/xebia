package com.assignment.xebia.controller;

import static org.hamcrest.Matchers.hasToString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.xebia.constants.Department;
import com.assignment.xebia.constants.Gender;
import com.assignment.xebia.model.Employee;
import com.assignment.xebia.service.employee.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)

public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BindingResult bindingResult;

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private WebApplicationContext wac;

	Employee employee = new Employee("Yuvaraj", "GGG", Gender.MALE, new Date(), Department.BUSINESS);

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void employeeRegisterSuccess() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/register")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).param("firstName", employee.getFirstName())
				.param("lastName", employee.getLastName())
				.param("dob", new SimpleDateFormat("yyyy-MM-dd").format(employee.getDob()))
				.param("department", String.valueOf(employee.getDepartment()))
				.param("gender", String.valueOf(employee.getGender()));

		mockMvc.perform(requestBuilder).andExpect(redirectedUrl("/employee/page/register"))
				.andExpect(flash().attribute("success", "Registration successful")).andReturn();
	}

	@Test
	public void employeeRegisterationFailureInvalidParameters() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/register")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED);

		mockMvc.perform(requestBuilder).andExpect(redirectedUrl("/employee/page/register"))
				.andExpect(flash().attribute("org.springframework.validation.BindingResult.employee",
						hasToString(Matchers.containsString("firstName field is mandatory"))))
				.andExpect(flash().attribute("org.springframework.validation.BindingResult.employee",
						hasToString(Matchers.containsString("lastName field is mandatory"))))
				.andExpect(flash().attribute("org.springframework.validation.BindingResult.employee",
						hasToString(Matchers.containsString("dob field is mandatory"))))
				.andExpect(flash().attribute("org.springframework.validation.BindingResult.employee",
						hasToString(Matchers.containsString("gender field is missing or invalid"))))
				.andExpect(flash().attribute("org.springframework.validation.BindingResult.employee",
						hasToString(Matchers.containsString("department field is missing or invalid"))))
				.andReturn();
	}

	@Test
	public void employeeListSuccess() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/employee/list")).andExpect(jsonPath("$").isArray());

	}

}
