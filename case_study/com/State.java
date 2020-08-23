package com;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STATE")
public class State {
	@Id @GeneratedValue
	@Column(name="STATE_ID")
	private int id; 
	
	@Column(name="STATE_CODE")
	private String statecode;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	public State() {
		super();
	}
	public State(String statecode, String stateName) {
		super();
		this.statecode = statecode;
		this.stateName = stateName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}
