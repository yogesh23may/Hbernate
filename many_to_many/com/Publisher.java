package com;

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
@Table(name="PUBLISHER")
public class Publisher {
	
	@Id @GeneratedValue
	@Column(name="PUBLISHER_ID")
	private int id;
	
	@Column(name="PUBLISHER_NAME")
	private String publisherName;
	
	@Column(name="PUBLISHER_LOC")
	private String publisherLoc;
	
	@ManyToMany
	@JoinTable(name="PUBLISHER_BOOK",joinColumns=@JoinColumn(name="PUBLISHER_ID"),inverseJoinColumns=@JoinColumn(name="BOOK_ID"))
	private Set<Book> bookSet = new HashSet<Book>();
	
	public Publisher() {
		super();
	}
	
	public Publisher(String publisherName, String publisherLoc) {
		super();
		this.publisherName = publisherName;
		this.publisherLoc = publisherLoc;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getPublisherLoc() {
		return publisherLoc;
	}
	public void setPublisherLoc(String publisherLoc) {
		this.publisherLoc = publisherLoc;
	}

	public Set<Book> getBookSet() {
		return bookSet;
	}

	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}
}
