package com;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
public class Department {
	@Id @GeneratedValue
	@Column(name="DEPARTMENT_ID")
	private int id;
	
	@Column(name="DEPARTMENT_NAME")
	private String name;
	
	@ManyToMany(mappedBy="departmentSet")
	private Set<Manager> managerSet = new HashSet<Manager>();
	
	public Department() {
		super();
	}
	public Department(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Manager> getManagerSet() {
		return managerSet;
	}
	public void setManagerSet(Set<Manager> managerSet) {
		this.managerSet = managerSet;
	}
}
