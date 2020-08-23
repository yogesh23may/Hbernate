package com.unidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROOM")
public class Room {
	@Id @GeneratedValue
	@Column(name="R_ID")
	private int id;
	
	@Column(name="R_ROOMNO")
	private String roomNo;
	
	@Column(name="R_TYPE")
	private String roomType;
	
	@Column(name="R_COST")
	private int roomCost;
	
	public Room() {
		super();
	}

	public Room(String roomNo, String roomType, int roomCost) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.roomCost = roomCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(int roomCost) {
		this.roomCost = roomCost;
	}
}
