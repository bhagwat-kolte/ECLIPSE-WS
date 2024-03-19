package com.amol.ems.bean;

public class DepartmentBean {
	private int departmentId;
	
	private String departmentName;
	
	private LocationBean location;

	/**
	 * 
	 */
	public DepartmentBean() {
		super();
	}

	/**
	 * @return the departmentId
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the location
	 */
	public LocationBean getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(LocationBean location) {
		this.location = location;
	}

}