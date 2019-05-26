package com.assignment.xebia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assignment.xebia.model.Employee;
import com.assignment.xebia.service.employee.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	private IEmployeeService employeeService;
	
	
	@GetMapping({"/", "/page/register"})
	public String index() {
		return "registration";
	}
	
	
	@GetMapping("/page/list")
	public String listEmployee() {
		return "employee-list";
	}
	
	
	@PostMapping(path="/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String register(@Valid Employee employee, BindingResult result, Model model) {
		System.out.println("Here");
		if(result.hasErrors()) {
			System.out.println(result.getFieldErrors());
			model.addAttribute("message", "Unable to Register");
		}else {
			employeeService.register(employee);
			model.addAttribute("message", "Registration successful");
		}
		
		return "registration"; 
	}
	

	@GetMapping("/list")
	public @ResponseBody List<Employee> list() {
		return employeeService.getAll();
	}
	
	
	
	
}
