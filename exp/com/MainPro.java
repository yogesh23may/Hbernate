package com;

import org.hibernate.Session;
import com.util.HibernateUtil;

public class MainPro {

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("hibernate");
				Heart h1 = new Heart();
				Body b1 = new Body();
				b1.setHeart(h1);
				
				session.beginTransaction();
					session.save(b1);
					session.save(h1);		
				session.getTransaction().commit();
	}
}
