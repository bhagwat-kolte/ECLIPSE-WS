/**
 * 
 */
package com.amol.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amol.ems.data.Employee;

/**
 * @author MACK-WORLD
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
