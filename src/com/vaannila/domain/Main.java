package com.vaannila.domain;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateUtil;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("vannilla");
		if(session!=null){
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				Person person = new Person();
					Addresss address1 = new Addresss();
						address1.setCity("Bangalore");
						address1.setState("Karnataka");
						address1.setStreet("Ring Road");
						address1.setZipcode("560000");
						address1.setPerson(person);
						
					Phone phone1 =new Phone();
						phone1.setPhoneNumber("9945564050");
						phone1.setPhoneType("smart");
						phone1.setPerson(person);
					
					Phone phone2 =new Phone();
						phone2.setPhoneNumber("879480868");
						phone2.setPhoneType("smart");
						phone2.setPerson(person);
					
					Set<Phone> phoneNumbers = new HashSet<Phone>();
						phoneNumbers.add(phone1);
						phoneNumbers.add(phone2);
			
					person.setPersonName("Yogesh");
					person.setPersonAddress(address1);
					person.setPersonPhoneNumbers(phoneNumbers);
		
					session.save(address1);
					session.save(phone1);
					session.save(phone2);
					session.save(person);
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}//end of main
}//end of vannilla