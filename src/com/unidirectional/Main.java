//realtion has to be uni-directional
//one admission has one patient
package com.unidirectional;

import java.util.Date;

import org.hibernate.Session;

import com.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("uni");
		boolean update = false;
		if(session!=null){
			if(!update){
				Patient patient = new Patient("Yogesh",48,"BANGALORE","23/05/88","9945564050");
				Room room = new Room("A502","SINGLE",4500);
				Receptionist receptionist = new Receptionist("AVATAR",21,"HYDERABAD","880376971");
				Admission admission = new Admission(patient, room, receptionist, new Date());
						
				session.beginTransaction();
					session.save(patient);
					session.save(room);
					session.save(receptionist);
					session.save(admission);
				session.getTransaction().commit();
			}else{
				Patient patient = (Patient) session.get(Patient.class,1);
				Receptionist receptionist = (Receptionist) session.get(Receptionist.class,1);
				Room room = (Room) session.get(Room.class,2);
				Admission admission = new Admission(patient,room, receptionist, new Date());
				
				session.beginTransaction();
				session.save(room);
				session.getTransaction().commit();
			}
			
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}
}
