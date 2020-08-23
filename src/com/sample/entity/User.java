package com.sample.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="ADUSER")
public class User {
	
	@Id @GeneratedValue
	@Column(name="A_ID")
	private long id;
	
	@Column(name="A_NAME")
	private String name;
	
	@Column(name="A_PASSWORD")
	private String password;
	
	@OneToMany(mappedBy="user")
	private Set<Advert> advert = new HashSet<Advert>();
	
	public User() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	protected long getId() {
		return id;
	}
	protected void setId(long id) {
		this.id = id;
	}

	public Set<Advert> getAdvert() {
		return advert;
	}
	public void setAdvert(Set<Advert> advert) {
		this.advert = advert;
	}
}