package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.util.HibernateUtil;

public class Main{

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("hibernate");
		if(session!=null){
			boolean check=false;
			if(check){
				User user = new User();//transient object
				
				Address address = new Address();
				address.setCity("BLR1");
				address.setState("KAR1");
				
				user.setName("User 31");
				user.setAddress(address);
				user.setEmails(null);
				
				session.beginTransaction();
				session.save(user);//persistent object
				session.saveOrUpdate(address);
				user.setName("test");
				user.setName("Hello User Test");
				session.getTransaction().commit();
				session.close();
				
				user.setName("Detached");//detached object
				/*
				session =  new HibernateUtil().getSession("hibernate");
				Transaction tran = session.beginTransaction();
				//session.merge(user);//persistent object
				session.saveOrUpdate(user);
				tran.commit();*/
			}else{
				try{
					User user = new User();
								
					Email email1 = new Email();
					email1.setEmailid("yy@yahoo.co.in");
					email1.setProvider("yahoo");
					email1.setUser(user);
					
					Email email2 = new Email();
					email2.setEmailid("yoya@gmail.com");
					email2.setProvider("gmail");
					email2.setUser(user);
					
					List<Email> lEmail = new ArrayList<Email>();
					lEmail.add(email1);
					lEmail.add(email2);
					
					Address address = new Address();
					address.setCity("LAS");
					address.setState("ORISSA");
					address.setUser(user);
					
					user.setName("GABRIEL");
					user.setEmails(lEmail);
					user.setAddress(address);
				
					Transaction tran = session.beginTransaction();
						session.save(email1);
						session.save(email2);
						session.save(user);
						session.save(address);
					tran.commit();
				}catch(Exception e){
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}//end of main
}//end of demo
