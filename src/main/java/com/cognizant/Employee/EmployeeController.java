package com.cognizant.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, value = "/employee")
	public void readFromCsv() {
		employeeService.readFromCsv();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employee/all")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employee/{firstName}")
	public List<Employee> getEmployeeByFirstName(@PathVariable String firstName) {
		return employeeService.getEmployeeByFirstName(firstName);
	}

}
