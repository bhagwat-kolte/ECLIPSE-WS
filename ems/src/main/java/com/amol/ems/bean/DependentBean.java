package com.amol.ems.bean;

public class DependentBean{
	
	private int dependentId;
	
	private String firstName;
	
	private String lastName;
	
	private String relationship;

	/**
	 * 
	 */
	public DependentBean() {
		super();
	}

	/**
	 * @return the dependentId
	 */
	public int getDependentId() {
		return dependentId;
	}

	/**
	 * @param dependentId the dependentId to set
	 */
	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
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
	 * @return the relationship
	 */
	public String getRelationship() {
		return relationship;
	}

	/**
	 * @param relationship the relationship to set
	 */
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
}