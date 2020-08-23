package com.uni;

import org.hibernate.Session;
import com.util.HibernateUtil;

public class MainUni {

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("one2one_uni");
		boolean update = false;
		if(session!=null){
			if(!update){
				Publisher publisher1 = new Publisher("TMH", "CALIFORNIA");
				Publisher publisher2 = new Publisher("Oreily", "USA");
				Book book = new Book("TRIGON", 245.00);
				book.setPublisher(publisher1);
				session.beginTransaction();
				session.save(book);
				/*session.save(publisher1);
				session.save(publisher2);*/
				session.getTransaction().commit();
			}else{
				session.beginTransaction();
				Book book = (Book) session.get(Book.class, 1);
				Publisher publisher = (Publisher) session.get(Publisher.class,1);
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("book can give publisher ,but vice versa not true ,so this is ONE TO ONE ,UNIDIRECTIONAL relationship\n");
				System.out.println("book details(book can give publisher):-");
				System.out.println("=====================================");
				System.out.println(book.getId() +"|"+ book.getBookName()  +"|"+ book.getCost() +"|"+ book.getPublisher().getId() +"|"+ book.getPublisher().getPublisherName() +"|"+ book.getPublisher().getPublisherLoc()+"\n");
				
				System.out.println("publisher details(publisher cannot give book):-");
				System.out.println("================================================");
				System.out.println(publisher.getId() +"|"+ publisher.getPublisherName() +"|"+ publisher.getPublisherLoc());
				session.getTransaction().commit();
			}			
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}
}
