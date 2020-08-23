package com.vaannila.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
	
	@Id @GeneratedValue
	@Column(name = "PERSON_ID")
	private long personId;
	
	@Column(name = "PERSON_NAME", nullable = false, length = 100)
	private String personName;
	
	@OneToOne(mappedBy="person")
	private Addresss personAddress;
	
	@OneToMany(mappedBy="person")
	private Set<Phone> personPhoneNumbers = new HashSet<Phone>();

	public Person() {
	}

	
	public long getPersonId() {
		return this.personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}


	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	
	public Addresss getPersonAddress() {
		return this.personAddress;
	}

	public void setPersonAddress(Addresss personAddress) {
		this.personAddress = personAddress;
	}

	public Set<Phone> getPersonPhoneNumbers() {
		return personPhoneNumbers;
	}

	public void setPersonPhoneNumbers(Set<Phone> personPhoneNumbers) {
		this.personPhoneNumbers = personPhoneNumbers;
	}

}