package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Entity
public class Heart {
	@Id @GeneratedValue
	private int id;

	@OneToOne(mappedBy= "heart")
	private Body body;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
}
