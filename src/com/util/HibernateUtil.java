package com.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private  SessionFactory sessionFactory;
	private  ServiceRegistry serviceRegistry;
	
	public Session getSession(String filename) {
		try{
		Configuration configuration = new Configuration();
		configuration.configure(filename+".cfg.xml");
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Exception e){
			System.err.println("exception occured in getSession" + e);
			return null;
		}
		return sessionFactory.openSession();
	}
}
