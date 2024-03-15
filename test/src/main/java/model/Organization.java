package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the organization database table.
 * 
 */
@Entity
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	private String metaTitle;

	@Lob
	private String profile;

	private String slug;

	private short status;

	@Lob
	private String summary;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="organization")
	private List<Employee> employees;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="createdBy")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="updatedBy")
	private User user2;

	//bi-directional many-to-one association to OrganizationMeta
	@OneToMany(mappedBy="organization")
	private List<OrganizationMeta> organizationMetas;

	public Organization() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getMetaTitle() {
		return this.metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setOrganization(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setOrganization(null);

		return employee;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public List<OrganizationMeta> getOrganizationMetas() {
		return this.organizationMetas;
	}

	public void setOrganizationMetas(List<OrganizationMeta> organizationMetas) {
		this.organizationMetas = organizationMetas;
	}

	public OrganizationMeta addOrganizationMeta(OrganizationMeta organizationMeta) {
		getOrganizationMetas().add(organizationMeta);
		organizationMeta.setOrganization(this);

		return organizationMeta;
	}

	public OrganizationMeta removeOrganizationMeta(OrganizationMeta organizationMeta) {
		getOrganizationMetas().remove(organizationMeta);
		organizationMeta.setOrganization(null);

		return organizationMeta;
	}

}