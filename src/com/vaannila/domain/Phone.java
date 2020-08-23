package com.vaannila.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class Phone implements java.io.Serializable {
	@Id @GeneratedValue
	@Column(name = "PHONE_ID")
	private long phoneId;
	
	@Column(name = "PHONE_TYPE", nullable = false, length=10)
	private String phoneType;
	
	@Column(name = "PHONE_NUMBER", nullable = false, length=15)
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="PHONE_PERSON")
	//@JoinTable(name = "PERSON_PHONE", joinColumns ={ @JoinColumn(name = "PERSON_ID") }, inverseJoinColumns ={ @JoinColumn(name = "PHONE_ID") })
	private Person person;
	
	public Phone() {}

	public long getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}