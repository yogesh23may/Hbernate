package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Body {
	@Id @GeneratedValue
	private int id;
	
	@OneToOne
	@JoinColumn(name = "H_FK")
	private Heart heart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Heart getHeart() {
		return heart;
	}

	public void setHeart(Heart heart) {
		this.heart = heart;
	}
	
	
}
