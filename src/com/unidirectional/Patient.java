package com.unidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import sun.security.util.BigInt;

@Entity
@Table(name="PATIENT")
public class Patient {
	@Id @GeneratedValue
	@Column(name="P_ID")
	private int id;
	
	@Column(name="P_NAME")
	private String name;
	
	@Column(name="P_AGE")
	private int age;
	
	@Column(name="P_ADDRESS")
	private String address;
	
	@Column(name="P_DOB")
	private String DOB;
	
	@Column(name="P_MOBILENO")
	private String MOB;
	
	public Patient() {
		super();
	}

	public Patient(String name, int age, String address, String dOB,String mOB) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		DOB = dOB;
		MOB = mOB;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getMOB() {
		return MOB;
	}

	public void setMOB(String mOB) {
		MOB = mOB;
	}
}
