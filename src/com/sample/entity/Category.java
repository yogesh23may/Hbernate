package com.sample.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Category {
	@Id @GeneratedValue
	@Column(name="C_ID")
	private long id;
	
	@Column(name="C_TITLE")
	private String title;
	
	@Column(name="C_TYPE")
	private String type;
	
	@ManyToMany
	@JoinColumn(name="CATEGORY_ADVERT")
	private Set<Advert> adverts = new HashSet<Advert>();
	
	public Category() {}
	public Set<Advert> getAdverts() {
		return adverts;
	}
	void setAdverts(Set<Advert> adverts) {
		this.adverts = adverts;
	}
	public void addAdvert(Advert advert) {
		getAdverts().add(advert);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	protected long getId() {
		return id;
	}
	protected void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}