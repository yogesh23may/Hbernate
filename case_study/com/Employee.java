package com;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id @GeneratedValue
	@Column(name="EMPLOYEE_ID")
	private int id;
	
	@Column(name="EMPLOYEE_NAME")
	private String name;
	
	@Column(name="EMPLOYEE_ADDRESS")
	private String address;
	
	@Column(name="EMPLOYEE_CITY")
	private String city;
	
	@Column(name="EMPLOYEE_PHONE")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private Manager manager;
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="STATE_ID")
	private State state;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String address, String city, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
