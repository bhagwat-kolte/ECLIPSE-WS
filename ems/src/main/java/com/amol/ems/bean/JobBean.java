package com.amol.ems.bean;

import java.math.BigDecimal;


public class JobBean {
	
	private int jobId;

	private String jobTitle;
	
	private BigDecimal maxSalary;
	
	private BigDecimal minSalary;

	/**
	 * 
	 */
	public JobBean() {
		super();
	}

	/**
	 * @return the jobId
	 */
	public int getJobId() {
		return jobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the maxSalary
	 */
	public BigDecimal getMaxSalary() {
		return maxSalary;
	}

	/**
	 * @param maxSalary the maxSalary to set
	 */
	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

	/**
	 * @return the minSalary
	 */
	public BigDecimal getMinSalary() {
		return minSalary;
	}

	/**
	 * @param minSalary the minSalary to set
	 */
	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}
}