package com.unidirectional;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADMISSION")
public class Admission {
	@Id @GeneratedValue	
	@Column(name="A_ID")
	private int id;
	
	@OneToOne
	@JoinColumn(name="A_PATIENT")
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name="A_ROOM")
	private Room room;
	
	@OneToOne
	@JoinColumn(name="A_RECEPTIONIST")
	private Receptionist receptionist;
	
	@Column(name="A_DATE")
	private Date date;
	
	public Admission() {
		super();
	}
	
	public Admission(Patient patient, Room room, Receptionist receptionist,Date date) {
		super();
		this.patient = patient;
		this.room = room;
		this.receptionist = receptionist;
		this.date = date;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Receptionist getReceptionist() {
		return receptionist;
	}

	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
