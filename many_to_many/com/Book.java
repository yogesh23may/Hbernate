//one book has many publication and vice versa
//it is a bi-directional relation

package com;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {
	
	@Id @GeneratedValue
	@Column(name = "BOOK_ID")
	private int id;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "BOOK_COST")
	private Double cost;
	
	@ManyToMany(mappedBy="bookSet")
	private Set<Publisher> publisherSet = new HashSet<Publisher>() ;
	
	public Book() {
		super();
	}
	
	public Book(String bookName, Double cost) {
		super();
		this.bookName = bookName;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Set<Publisher> getPublisherSet() {
		return publisherSet;
	}

	public void setPublisherSet(Set<Publisher> publisherSet) {
		this.publisherSet = publisherSet;
	}
}
