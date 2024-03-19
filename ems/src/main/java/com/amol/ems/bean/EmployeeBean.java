/**
 * 
 */
package com.amol.ems.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author MACK-WORLD
 *
 */
public class EmployeeBean {
	
	private int employeeId;

	private String email;
	
	private String firstName;
	
	private Date hireDate;
	
	private String lastName;
	
	private String phoneNumber;

	private BigDecimal salary;
	
	private List<DependentBean> dependents;
	
	private JobBean job;
	
	private DepartmentBean department;

	/**
	 * 
	 */
	public EmployeeBean() {
		super();
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	/**
	 * @return the dependents
	 */
	public List<DependentBean> getDependents() {
		return dependents;
	}

	/**
	 * @param dependents the dependents to set
	 */
	public void setDependents(List<DependentBean> dependents) {
		this.dependents = dependents;
	}

	/**
	 * @return the job
	 */
	public JobBean getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(JobBean job) {
		this.job = job;
	}

	/**
	 * @return the department
	 */
	public DepartmentBean getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(DepartmentBean department) {
		this.department = department;
	}
}
