/**
 * 
 */
package com.amol.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.ems.dao.EmployeeRepository;
import com.amol.ems.data.Employee;

/**
 * @author MACK-WORLD
 *
 */
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee(){
		List<Employee> employees = new ArrayList<>();
		
		employees = employeeRepository.findAll();
		return employees;
	}
	

}
