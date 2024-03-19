/**
 * 
 */
package com.amol.ems.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.ems.dao.EmployeeRepository;
import com.amol.ems.data.Country;
import com.amol.ems.data.Employee;
import com.amol.ems.data.Location;
import com.amol.ems.data.Region;
import com.amol.ems.bean.EmployeeBean;
import com.amol.ems.bean.JobBean;
import com.amol.ems.bean.DependentBean;
import com.amol.ems.bean.CountryBean;
import com.amol.ems.bean.DepartmentBean;
import com.amol.ems.bean.LocationBean;
import com.amol.ems.bean.RegionBean;

/**
 * @author MACK-WORLD
 *
 */
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	List<Employee> employees = new ArrayList<>();
	List<EmployeeBean> employeeBeans = new ArrayList<>();
	
	Employee em = new Employee();
	EmployeeBean employeeBean = null;
	
	public List<EmployeeBean> getAllEmployee(){
		employees.clear();
		employeeBeans.clear();
		employees = employeeRepository.findAll();
		
		employees.forEach(em ->{employeeBeans.add(moveEmployeeDataTOBean(em));
		});
		return employeeBeans;
	}

	public EmployeeBean getEmployee(int employeeId) {
		
		if(employeeRepository.findById((long) employeeId).isPresent()) {
			
			em = employeeRepository.findById((long) employeeId).get();
			employeeBean = moveEmployeeDataTOBean(em);
		}
		return employeeBean;
	}
	
	public List<EmployeeBean> getEmployeesByFirstName(String firstName){
		employees.clear();
		employeeBeans.clear();
		employees = employeeRepository.findByFirstName(firstName);
		if(employees.size() > 0) {			
			employees.forEach(em -> employeeBeans.add(moveEmployeeDataTOBean(em)));
		}
		return employeeBeans;
	}
	
	public List<EmployeeBean> getEmployeesByLastName(String lastName){
		employees.clear();
		employeeBeans.clear();
		employees = employeeRepository.findByLastName(lastName);
		
		if(employees.size() > 0) {		
			
			employees.forEach(em -> employeeBeans.add(moveEmployeeDataTOBean(em)));
		}
		return employeeBeans;
	}
	
	public List<EmployeeBean> getEmployeesByName(String firstName, String lastName){
		employees.clear();
		employeeBeans.clear();
		employees = employeeRepository.findByName(firstName, lastName);
		
		if(employees.size() > 0)
			employees.forEach(em -> employeeBeans.add(moveEmployeeDataTOBean(em)));
		
		return employeeBeans;
	}
	
	public List<EmployeeBean> getEmployeesByHireDate(Date hireDate){
		employees.clear();
		employeeBeans.clear();
		employees = employeeRepository.findByHireDate(hireDate);
		
		if(employees.size() > 0)
			employees.forEach(em -> employeeBeans.add(moveEmployeeDataTOBean(em)));
		return employeeBeans;
	}
	
	public List<EmployeeBean> getEmployeesByPhoneNumber(String phoneNumber){
		employees.clear();
		employeeBeans.clear();
		employees = employeeRepository.findByPhoneNumber(phoneNumber);
		
		if(employees.size() > 0)
			employees.forEach(em -> employeeBeans.add(moveEmployeeDataTOBean(em)));
		
		return employeeBeans;
	}
	
	public List<EmployeeBean> getEmployeesBySalary(BigDecimal salary){
		employees.clear();
		employeeBeans.clear();
		employees = employeeRepository.findBySalary(salary);
		
		if(employees.size() > 0)
			employees.forEach(em -> employeeBeans.add(moveEmployeeDataTOBean(em)));
		
		return employeeBeans;
	}
	
	public EmployeeBean moveEmployeeDataTOBean(Employee em) {
		List<DependentBean> dependents = new ArrayList<>();
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmployeeId(em.getEmployeeId());
		employeeBean.setEmail(em.getEmail());
		employeeBean.setFirstName(em.getFirstName());
		employeeBean.setHireDate(em.getHireDate());
		employeeBean.setLastName(em.getLastName());
		employeeBean.setPhoneNumber(em.getPhoneNumber());
		employeeBean.setSalary(em.getSalary());
		
		em.getDependents().forEach(dp ->{
			DependentBean dependentBean = new DependentBean();
			dependentBean.setDependentId(dp.getDependentId());
			dependentBean.setFirstName(dp.getFirstName());
			dependentBean.setLastName(dp.getLastName());
			dependentBean.setRelationship(dp.getRelationship());
			dependents.add(dependentBean);
		});
		
		employeeBean.setDependents(dependents);
		
		JobBean job = new JobBean();
		job.setJobId(em.getJob().getJobId());
		job.setJobTitle(em.getJob().getJobTitle());
		job.setMaxSalary(em.getJob().getMaxSalary());
		job.setMinSalary(em.getJob().getMinSalary());
		employeeBean.setJob(job);
		
		DepartmentBean dept = new DepartmentBean();
		dept.setDepartmentId(em.getDepartment().getDepartmentId());
		dept.setDepartmentName(em.getDepartment().getDepartmentName());
		employeeBean.setDepartment(dept);
		
		Location loc = em.getDepartment().getLocation();
		LocationBean lc = new LocationBean();
		lc.setLocationId(loc.getLocationId());
		lc.setCity(loc.getCity());
		lc.setPostalCode(loc.getPostalCode());
		lc.setStateProvince(loc.getStateProvince());
		lc.setStreetAddress(loc.getStreetAddress());
		employeeBean.getDepartment().setLocation(lc);
		
		Country ctr = em.getDepartment().getLocation().getCountry();
		CountryBean country = new CountryBean();			
		country.setCountryId(ctr.getCountryId());
		country.setCountryName(ctr.getCountryName());
		employeeBean.getDepartment().getLocation().setCountry(country);
		
		Region rg = em.getDepartment().getLocation().getCountry().getRegion();
		RegionBean reg = new RegionBean();			
		reg.setRegionId(rg.getRegionId());
		reg.setRegionName(rg.getRegionName());
		employeeBean.getDepartment().getLocation().getCountry().setRegion(reg);
		
		return employeeBean;
	}
}
