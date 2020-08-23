package com.unidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECEPTIONIST")
public class Receptionist {
	@Id @GeneratedValue
	@Column(name="REC_ID")
	private int id;
	
	@Column(name="REC_NAME")
	private String recpName;
	
	@Column(name="REC_AGE")
	private int age;
	
	@Column(name="REC_ADDRESS")
	private String address;
	
	@Column(name="REC_MOBILENO")
	private String MOB;
	
	public Receptionist() {
		super();
	}
	public Receptionist(String recpName, int age, String address,String mOB) {
		super();
		this.recpName = recpName;
		this.age = age;
		this.address = address;
		MOB = mOB;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecpName() {
		return recpName;
	}

	public void setRecpName(String recpName) {
		this.recpName = recpName;
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

	public String getMOB() {
		return MOB;
	}

	public void setMOB(String mOB) {
		MOB = mOB;
	}
}
