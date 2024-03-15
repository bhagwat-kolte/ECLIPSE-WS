package com.amol.ems.data;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String email;

	private String firstName;

	@Lob
	private String intro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;

	private String lastName;

	private String middleName;

	private String mobile;

	private String passwordHash;

	@Lob
	private String profile;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredAt;

	private String username;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="user1")
	private List<Employee> employees1;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="user2")
	private List<Employee> employees2;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="user3")
	private List<Employee> employees3;

	//bi-directional many-to-one association to Organization
	@OneToMany(mappedBy="user1")
	private List<Organization> organizations1;

	//bi-directional many-to-one association to Organization
	@OneToMany(mappedBy="user2")
	private List<Organization> organizations2;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Date getRegisteredAt() {
		return this.registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Employee> getEmployees1() {
		return this.employees1;
	}

	public void setEmployees1(List<Employee> employees1) {
		this.employees1 = employees1;
	}

	public Employee addEmployees1(Employee employees1) {
		getEmployees1().add(employees1);
		employees1.setUser1(this);

		return employees1;
	}

	public Employee removeEmployees1(Employee employees1) {
		getEmployees1().remove(employees1);
		employees1.setUser1(null);

		return employees1;
	}

	public List<Employee> getEmployees2() {
		return this.employees2;
	}

	public void setEmployees2(List<Employee> employees2) {
		this.employees2 = employees2;
	}

	public Employee addEmployees2(Employee employees2) {
		getEmployees2().add(employees2);
		employees2.setUser2(this);

		return employees2;
	}

	public Employee removeEmployees2(Employee employees2) {
		getEmployees2().remove(employees2);
		employees2.setUser2(null);

		return employees2;
	}

	public List<Employee> getEmployees3() {
		return this.employees3;
	}

	public void setEmployees3(List<Employee> employees3) {
		this.employees3 = employees3;
	}

	public Employee addEmployees3(Employee employees3) {
		getEmployees3().add(employees3);
		employees3.setUser3(this);

		return employees3;
	}

	public Employee removeEmployees3(Employee employees3) {
		getEmployees3().remove(employees3);
		employees3.setUser3(null);

		return employees3;
	}

	public List<Organization> getOrganizations1() {
		return this.organizations1;
	}

	public void setOrganizations1(List<Organization> organizations1) {
		this.organizations1 = organizations1;
	}

	public Organization addOrganizations1(Organization organizations1) {
		getOrganizations1().add(organizations1);
		organizations1.setUser1(this);

		return organizations1;
	}

	public Organization removeOrganizations1(Organization organizations1) {
		getOrganizations1().remove(organizations1);
		organizations1.setUser1(null);

		return organizations1;
	}

	public List<Organization> getOrganizations2() {
		return this.organizations2;
	}

	public void setOrganizations2(List<Organization> organizations2) {
		this.organizations2 = organizations2;
	}

	public Organization addOrganizations2(Organization organizations2) {
		getOrganizations2().add(organizations2);
		organizations2.setUser2(this);

		return organizations2;
	}

	public Organization removeOrganizations2(Organization organizations2) {
		getOrganizations2().remove(organizations2);
		organizations2.setUser2(null);

		return organizations2;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}