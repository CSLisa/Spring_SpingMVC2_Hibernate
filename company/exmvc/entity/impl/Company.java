package exmvc.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "COMPANY", schema = "SCOTT")

public class Company implements java.io.Serializable {

	@Override
	public String toString() {
		return "Company [id=" + id + ", parentId=" + parentId + ", name=" + name + "]";
	}

	// Fields
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	private String id;
	@Column(name = "parentId", length = 50)
	private String parentId;
	@Column(name = "NAME", length = 50)
	private String name;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** minimal constructor */
	public Company(String id) {
		this.id = id;
	}

	/** full constructor */
	public Company(String id, String parentId, String name) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
	}

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}