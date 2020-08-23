package com.uni;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.util.HibernateUtil;

public class MainUniOneToManyV {

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("one2many_uni");
		boolean update = true;
		if(session!=null){
			if(!update){
				MyPublisher publisher1 = new MyPublisher("TMH", "CALIFORNIA");
				MyPublisher publisher2 = new MyPublisher("Oreily", "USA");
				MyPublisher publisher3 = new MyPublisher("TutorialPoint", "INDIA");
				
				Set<MyPublisher> pubSet1 = new HashSet<MyPublisher>();
				pubSet1.add(publisher1);
				pubSet1.add(publisher2);
				pubSet1.add(publisher3);
				MyBook book1 = new MyBook("TRIGONOMETRY", 245.00);
				book1.setMyPublisher(pubSet1);
				
				MyBook book2 = new MyBook("SCIENCE", 505.00);
				Set<MyPublisher> pubSet2 = new HashSet<MyPublisher>();
				MyPublisher publisher4 = new MyPublisher("Andrew", "AUSTRIA");pubSet2.add(publisher4);
				book2.setMyPublisher(pubSet2);
				
				session.beginTransaction();
					session.save(publisher1);
					session.save(publisher2);
					session.save(publisher3);
					session.save(book1);
					session.save(publisher4);
					session.save(book2);
				session.getTransaction().commit();
			}else{
				session.beginTransaction();
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("book can give many publisher ,but vice versa not true ,so this is ONE TO MANY ,UNIDIRECTIONAL relationship");
				MyBook mybookOb = (MyBook) session.get(MyBook.class, 1);
				System.out.println("book details(book can give publishers):-");
				System.out.println("=====================================");
				System.out.println(mybookOb.getId() +"|"+ mybookOb.getBookName() +"|"+ mybookOb.getCost());
				System.out.println("publishers:-");
				System.out.println("============");
				Set<MyPublisher> setPub = mybookOb.getMyPublisher();
				Iterator<MyPublisher> i = setPub.iterator();
				while(i.hasNext()){
					MyPublisher next = i.next();
					System.out.println(next.getId() +"|"+ next.getPublisherName() +"|"+ next.getPublisherLoc() +"\n" );
				}
				
				MyPublisher myPub = (MyPublisher) session.get(MyPublisher.class,1);
				System.out.println("publisher details(publisher cannot give book):-");
				System.out.println("================================================");
				System.out.println(myPub.getId() +"|"+ myPub.getPublisherLoc() +"|"+ myPub.getPublisherName());
				session.getTransaction().commit();
			}			
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}
}
