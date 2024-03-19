/**
 * 
 */
package com.amol.ems.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amol.ems.data.Employee;

/**
 * @author MACK-WORLD
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("select e from Employee e where e.firstName = ?1")
	List<Employee> findByFirstName(String firstName);
	
	@Query("select e from Employee e where e.lastName = ?1")
	List<Employee> findByLastName(String lastName);
	
	@Query("select e from Employee e where e.firstName = ?1 and e.lastName = ?2")
	List<Employee> findByName(String firstName, String lastName);
	
	@Query("select e from Employee e where e.hireDate = ?1")
	List<Employee> findByHireDate(Date hireDate);
	
	@Query("select e from Employee e where e.phoneNumber = ?1")
	List<Employee> findByPhoneNumber(String phoneNumber);
	
	@Query("select e from Employee e where e.salary = ?1")
	List<Employee> findBySalary(BigDecimal salary);
}
