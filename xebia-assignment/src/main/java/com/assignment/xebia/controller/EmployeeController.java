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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assignment.xebia.model.Employee;
import com.assignment.xebia.service.employee.IEmployeeService;

/**
 * 
 * @author YU296490 Handles all http requests for Employee management operations
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	private IEmployeeService employeeService;
	

	/**
	 * @param model
	 * @return 
	 * Method directs user to registration page
	 */
	@GetMapping({ "/", "/page/register" })
	public String index(Model model) {
		model.addAttribute("registration", "active");
		if (!model.containsAttribute("employee")) {
			model.addAttribute("employee", new Employee());
		}
		return "registration";
	}

	/**
	 * @param model
	 * @return
	 * Method directs user to employee list page
	 */
	@GetMapping("/page/list")
	public String listEmployee(Model model) {
		model.addAttribute("view", "active");
		return "employee-list";
	}

	
	/**
	 * 
	 * @param employee
	 * @param result
	 * @param redirectAttrs
	 * @return 
	 * Method registers a new employee
	 */
	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String register(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			RedirectAttributes redirectAttrs) {

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.employee", result);
			redirectAttrs.addFlashAttribute("employee", employee);
		} else {
			employeeService.registerEmployee(employee);
			redirectAttrs.addFlashAttribute("success", "Registration successful");
		}

		return "redirect:/employee/page/register";
	}

	
	/**
	 * @return
	 * Method fetches all the available employees
	 */
	@GetMapping("/list")
	public @ResponseBody List<Employee> list() {
		return employeeService.getAllEmployees();
	}

}
