/**
 * 
 */
package com.amol.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amol.ems.data.Employee;
import com.amol.ems.service.EmployeeService;
import com.amol.ems.dao.EmployeeRepository;

/**
 * @author MACK-WORLD
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee/all")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}

}
