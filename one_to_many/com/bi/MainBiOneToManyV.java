package com.bi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import com.util.HibernateUtil;

public class MainBiOneToManyV {

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("one2many_bi");
		boolean create = true;
		boolean updateNew = false;
		if(session!=null){
			if(create){
				MyPublisher publisher1 = new MyPublisher("TMH", "CALIFORNIA");
				MyPublisher publisher2 = new MyPublisher("Oreily", "USA");
				MyPublisher publisher3 = new MyPublisher("TutorialPoint", "INDIA");
				
				Set<MyPublisher> pubSet1 = new HashSet<MyPublisher>();
				pubSet1.add(publisher1);pubSet1.add(publisher2);pubSet1.add(publisher3);
				
				MyBook book1 = new MyBook("TRIGONOMETRY", 245.00);
				book1.setMyPublisher(pubSet1);
				
				publisher1.setMyBook(book1);publisher2.setMyBook(book1);publisher3.setMyBook(book1);
	
				session.beginTransaction();
					session.save(publisher1);
					session.save(publisher2);
					session.save(publisher3);
					session.save(book1);
				session.getTransaction().commit();
			}else if(updateNew){
				session.beginTransaction();
				
				Set<MyPublisher> pubSet2 = new HashSet<MyPublisher>();
				MyPublisher publisher4 = new MyPublisher("KathSiera", "ENGLAND");
				MyPublisher publisher1 = (MyPublisher) session.get(MyPublisher.class,1);
				pubSet2.add(publisher1);pubSet2.add(publisher4);
				
				//MyBook book2 = new MyBook("SCIENCE", 505.00);
				MyBook book2 = (MyBook) session.get(MyBook.class,2);
				book2.setMyPublisher(pubSet2);
				
				publisher1.setMyBook(book2);publisher4.setMyBook(book2);
				
				session.save(publisher4);
				session.merge(book2);
				
				session.getTransaction().commit();
			}else{
				session.beginTransaction();
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("book can give many publisher and publisher can give book also,so this is ONE TO MANY ,BI-DIRECTIONAL relationship");
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
				System.out.println("publisher details(publisher can give book):-");
				System.out.println("================================================");
				System.out.println(myPub.getId() +"|"+ myPub.getPublisherLoc() +"|"+ myPub.getPublisherName());
				System.out.println("book:-");
				System.out.println("============");
				MyBook myBook = myPub.getMyBook();
				System.out.println(myBook.getId() +"|"+ myBook.getBookName() +"|"+ myBook.getCost() );
				session.getTransaction().commit();
			}		
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}
}
