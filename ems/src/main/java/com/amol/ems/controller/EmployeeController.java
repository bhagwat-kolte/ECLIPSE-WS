/**
 * 
 */
package com.amol.ems.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amol.ems.bean.EMSErrorResponse;
import com.amol.ems.bean.EmployeeBean;
import com.amol.ems.exceptions.EmployeeNotFoundException;
import com.amol.ems.service.EmployeeService;

/**
 * @author MACK-WORLD
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;	
	
	@ExceptionHandler
	public ResponseEntity<EMSErrorResponse> handleException(EmployeeNotFoundException exc){
		EMSErrorResponse errorResponse = new EMSErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);		
	}
	
	@GetMapping("/employee/all")
	public List<EmployeeBean> getAllEmployees(){
		List<EmployeeBean> employees = employeeService.getAllEmployee();
		
		if(null == employees || employees.isEmpty() || employees.size() == 0) {
			throw new EmployeeNotFoundException("No Employee found");
		}
		return employees;
	}
	
	@GetMapping("/employee")
	public EmployeeBean getEmployee(@RequestParam("employeeId") int employeeId){
		EmployeeBean employee = employeeService.getEmployee(employeeId);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("No Employee found: " + employeeId);
		}
		return employee;
	}
	
	@GetMapping("/employee/firstName")
	public List<EmployeeBean> getEmployeesByFirstName(@RequestParam("firstName") String firstName){
		List<EmployeeBean> employees = employeeService.getEmployeesByFirstName(firstName);
		
		if(null == employees || employees.isEmpty() || employees.size() == 0) {
			throw new EmployeeNotFoundException("No Employee found : " + firstName);
		}
		return employees;
	}
	
	@GetMapping("/employee/lastName")
	public List<EmployeeBean> getEmployeesByLastName(@RequestParam("lastName") String lastName){
		List<EmployeeBean> employees = employeeService.getEmployeesByLastName(lastName);
		
		if(null == employees || employees.isEmpty() || employees.size() == 0) {
			throw new EmployeeNotFoundException("No Employee found : " + lastName);
		}
		return employees;
	}
	
	@GetMapping("/employee/name")
	public List<EmployeeBean> getEmployeesByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
		List<EmployeeBean> employees = employeeService.getEmployeesByName(firstName, lastName);
		
		if(null == employees || employees.isEmpty() || employees.size() == 0) {
			throw new EmployeeNotFoundException("No Employee found : " + firstName +" "+ lastName);
		}
		return employees;
	}
	
	@GetMapping("/employee/hireDate")
	public List<EmployeeBean> getEmployeesByHireDate(@RequestParam("hireDate") String hireDate) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		List<EmployeeBean> employees = employeeService.getEmployeesByHireDate(formatter.parse(hireDate));
		
		if(null == employees || employees.isEmpty() || employees.size() == 0) {
			throw new EmployeeNotFoundException("No Employee found : " + hireDate);
		}
		return employees;
	}
	
	@GetMapping("/employee/phone")
	public List<EmployeeBean> getEmployeesByPhone(@RequestParam("phoneNumber") String phoneNumber){
		List<EmployeeBean> employees = employeeService.getEmployeesByPhoneNumber(phoneNumber);
		
		if(null == employees || employees.isEmpty() || employees.size() == 0) {
			throw new EmployeeNotFoundException("No Employee found : " + phoneNumber);
		}
		return employees;
	}
	
	@GetMapping("/employee/pay")
	public List<EmployeeBean> getEmployeesByPay(@RequestParam("salary") BigDecimal salary){
		List<EmployeeBean> employees = employeeService.getEmployeesBySalary(salary);
		
		if(null == employees || employees.isEmpty() || employees.size() == 0) {
			throw new EmployeeNotFoundException("No Employee found : " + salary);
		}
		return employees;
	}

}
