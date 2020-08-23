package com;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import com.Book;
import com.Publisher;
import com.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("many2many");
		boolean create = false;
		boolean updateNew = false;
		if(session!=null){
			if(create){
				Publisher publisher1 = new Publisher("TMH", "CALIFORNIA");
				Publisher publisher2 = new Publisher("Oreily", "USA");
				Publisher publisher3 = new Publisher("TutorialPoint", "INDIA");
				
				Book book1 = new Book("TRIGONOMETRY", 245.00);
				
				Set<Publisher> pubSet1 = new HashSet<Publisher>();
				pubSet1.add(publisher1);pubSet1.add(publisher2);pubSet1.add(publisher3);
				
				Set<Book> bookSet1 = new HashSet<Book>();
				bookSet1.add(book1);
				
				book1.setPublisherSet(pubSet1);
				publisher1.setBookSet(bookSet1);publisher2.setBookSet(bookSet1);publisher3.setBookSet(bookSet1);
				
				session.beginTransaction();
					session.save(publisher1);
					session.save(publisher2);
					session.save(publisher3);
					session.save(book1);
				session.getTransaction().commit();
			}else if(updateNew){
				session.beginTransaction();
				
				Publisher publisher4 = new Publisher("AdsonWisley", "NY");
				
				Book book1 = (Book) session.get(Book.class,1);
				Book book2 = new Book("SCIENCE", 500.00);
				
				Set<Publisher> pubSet1 = new HashSet<Publisher>();
				pubSet1.add(publisher4);
				
				Set<Book> bookSet1 = new HashSet<Book>();
				bookSet1.add(book1);bookSet1.add(book2);
				
				book1.setPublisherSet(pubSet1);book2.setPublisherSet(pubSet1);
				publisher4.setBookSet(bookSet1);
				
				session.save(publisher4);
				session.merge(book1);
				session.save(book2);
				session.getTransaction().commit();
			}else{
				session.beginTransaction();
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("book can give many publisher and vice versa,so this is MANY TO MANY ,BI-DIRECTIONAL relationship");
				Book mybookOb = (Book) session.get(Book.class, 1);
				System.out.println("book details(book can give publishers):-");
				System.out.println("=====================================");
				System.out.println(mybookOb.getId() +"|"+ mybookOb.getBookName() +"|"+ mybookOb.getCost());
				System.out.println("publishers:-");
				System.out.println("============");
				Set<Publisher> setPub = mybookOb.getPublisherSet();
				Iterator<Publisher> i = setPub.iterator();
				while(i.hasNext()){
					Publisher next = i.next();
					System.out.println(next.getId() +"|"+ next.getPublisherName() +"|"+ next.getPublisherLoc() +"\n" );
				}
				
				Publisher myPub = (Publisher) session.get(Publisher.class,4);
				System.out.println("publisher details(publisher can give books):-");
				System.out.println("================================================");
				System.out.println(myPub.getId() +"|"+ myPub.getPublisherLoc() +"|"+ myPub.getPublisherName());
				System.out.println("books:-");
				System.out.println("========");
				Set<Book> setBook = myPub.getBookSet();
				Iterator<Book> it = setBook.iterator();
				while(it.hasNext()){
					Book next = it.next();
					System.out.println(next.getId() +"|"+ next.getBookName() +"|"+ next.getCost() +"\n" );
				}
				session.getTransaction().commit();
			}		
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}
}
