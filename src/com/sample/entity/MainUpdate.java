package com.sample.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.util.HibernateUtil;

public class MainUpdate {

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("sample");
		if(session!=null){
			try{
				session.beginTransaction();
				User user = new User();
					user.setName("awadhesh");	user.setPassword("12345");
								
					Category category = new Category();Advert advert1 = new Advert();Advert advert2 = new Advert();	
					category.setTitle("toys");category.setType("soft");
						
					advert1.setTitle("cars");advert1.setMessage("verna");
					advert1.setUser(user);
					Set<Category> categories = new HashSet<Category>();categories.add(category);
					advert1.setCategories(categories);
					
					advert2.setTitle("chhota bhim");advert2.setMessage("play it");
					advert2.setUser(user);
					advert2.setCategories(categories);
					
					Set<Advert> adverts = new HashSet<Advert>();adverts.add(advert1);adverts.add(advert2);
					category.setAdverts(adverts);
				
				session.save(user);	
				session.save(advert1);session.save(advert2);
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

	}

}
