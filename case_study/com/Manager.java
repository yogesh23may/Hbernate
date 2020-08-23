package com;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MANAGER")
public class Manager {
	@Id @GeneratedValue
	@Column(name="MANAGER_ID")
	private int id;
	
	@Column(name="MANAGER_LEVEL")
	private String level;
	
	@ManyToMany
	@JoinTable(name="MANAGER_DEPARTMENT",joinColumns=@JoinColumn(name="MANAGER_ID"),inverseJoinColumns=@JoinColumn(name="DEPARTMENT_ID"))
	private Set<Department> departmentSet = new HashSet<Department>();
	
	public Manager() {
		super();
	}
	
	public Manager(String level) {
		super();
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Set<Department> getDepartmentSet() {
		return departmentSet;
	}
	public void setDepartmentSet(Set<Department> departmentSet) {
		this.departmentSet = departmentSet;
	}
}
