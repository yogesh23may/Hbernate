package com.sample.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("sample");
		if(session!=null){
			try{
				session.beginTransaction();
				User user = new User();
					user.setName("yogesh");	user.setPassword("yogesh");
								
				Category category = new Category();Advert advert = new Advert();
					category.setTitle("cosmetics");category.setType("hair");
								
					advert.setTitle("Shampoo");advert.setMessage("helloHair");
					advert.setUser(user);
					Set<Category> categories = new HashSet<Category>();categories.add(category);
					advert.setCategories(categories);
					
					Set<Advert> adverts = new HashSet<Advert>();adverts.add(advert);
					category.setAdverts(adverts);
				
				session.save(user);	
				session.save(advert);
				session.save(category);	
				session.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}//end of main
}//end of sample
