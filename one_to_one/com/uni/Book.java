//one book has only one publication
//it is a uni-directional relation

package com.uni;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="BOOK")
public class Book {
	
	@Id @GeneratedValue
	@Column(name = "B_ID")
	private int id;
	
	@Column(name = "B_NAME")
	private String bookName;
	
	@Column(name = "B_COST")
	private Double cost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="B_PUBLISHER")
	private Publisher publisher;
	
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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}
