package com.sample.entity;
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
@Table(name="ADVERT")
public class Advert {
	@Id @GeneratedValue
	private long id;
	
	@Column(name="")
	private String title;
	
	@Column(name="")
	private String message;
	
	@ManyToOne
	@JoinColumn(name="ADVERT_USER")
	private User user;
	
	@ManyToMany(mappedBy="adverts")
	private Set<Category> categories = new HashSet<Category>();

	Advert() {}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	protected long getId() {
		return id;
	}
	protected void setId(long id) {
		this.id = id;
	}
}