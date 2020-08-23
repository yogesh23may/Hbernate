package com.uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PUBLISHER")
public class MyPublisher {
	
	@Id @GeneratedValue
	@Column(name="P_ID")
	private int id;
	
	@Column(name="P_NAME")
	private String publisherName;
	
	@Column(name="P_LOC")
	private String publisherLoc;
	
	public MyPublisher() {
		super();
	}
	
	public MyPublisher(String publisherName, String publisherLoc) {
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
}

