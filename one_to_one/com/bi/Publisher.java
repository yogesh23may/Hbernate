package com.bi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PUBLISHER")
public class Publisher {
	
	@Id @GeneratedValue
	@Column(name="P_ID")
	private int id;
	
	@Column(name="P_NAME")
	private String publisherName;
	
	@Column(name="P_LOC")
	private String publisherLoc;
	
	@OneToOne(mappedBy="publisher")
	private Book book; 
	
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
