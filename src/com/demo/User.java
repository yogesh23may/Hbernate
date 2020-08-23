package com.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TABLE")
public class User {

	@Id @GeneratedValue
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToOne(mappedBy="user")
	private Address address;
	
	@OneToMany(mappedBy="user")
	//@JoinTable(name="USER_EMAIL",joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="EMAIL_ID"))
	private List<Email> emails = new ArrayList<Email>();
	
	public User(){}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

}
