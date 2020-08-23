//one book has many publication
//it is a uni-directional relation
//it is not much meaningful 

package com.uni;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class MyBook {
	
	@Id @GeneratedValue
	@Column(name = "B_ID")
	private int id;
	
	@Column(name = "B_NAME")
	private String bookName;
	
	@Column(name = "B_COST")
	private Double cost;
	
	@OneToMany
	//@JoinColumn(name="BOOK_PUBLISHER")
	@JoinTable(name="BOOK_PUBLISHER",joinColumns=@JoinColumn(name="B_ID"),inverseJoinColumns=@JoinColumn(name="P_ID"))
	private Set<MyPublisher> myPublisher = new HashSet<MyPublisher>();
		
	public MyBook() {
		super();
	}
	
	public MyBook(String bookName, Double cost) {
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

	public Set<MyPublisher> getMyPublisher() {
		return myPublisher;
	}

	public void setMyPublisher(Set<MyPublisher> myPublisher) {
		this.myPublisher = myPublisher;
	}

}
