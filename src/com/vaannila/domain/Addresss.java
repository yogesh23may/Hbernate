package com.vaannila.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESSS")
public class Addresss implements Serializable {
	@Id @GeneratedValue
	@Column(name = "ADDRESSS_ID")
	private long addressId;
	
	@Column(name = "ADDRESSS_STREET", nullable = false, length=250)
	private String street;
	
	@Column(name = "ADDRESSS_CITY", nullable = false, length=50)
	private String city;
	
	@Column(name = "ADDRESSS_STATE", nullable = false, length=50)
	private String state;
	
	@Column(name = "ADDRESSS_ZIPCODE", nullable = false, length=10)
	private String zipcode;
	
	@OneToOne
	@JoinColumn(name="ADDRESSS_PERSON")
	private Person person;

	public Addresss() {}

	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}