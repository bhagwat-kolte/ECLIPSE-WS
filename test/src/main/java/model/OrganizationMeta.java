package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the organization_meta database table.
 * 
 */
@Entity
@Table(name="organization_meta")
@NamedQuery(name="OrganizationMeta.findAll", query="SELECT o FROM OrganizationMeta o")
public class OrganizationMeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	private String content;

	private String key;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="organizationId")
	private Organization organization;

	public OrganizationMeta() {
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

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}