package com.amol.ems.data;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the dependents database table.
 * 
 */
@Entity
@Table(name="dependents")
@NamedQuery(name="Dependent.findAll", query="SELECT d FROM Dependent d")
public class Dependent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dependent_id")
	private int dependentId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String relationship;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	public Dependent() {
	}

	public int getDependentId() {
		return this.dependentId;
	}

	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}