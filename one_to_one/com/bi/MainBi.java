package com.bi;

import org.hibernate.Session;
import com.util.HibernateUtil;

public class MainBi {

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("one2one_bi");
		boolean update = true;
		if(session!=null){
			if(!update){
				Publisher publisher = new Publisher("TMH", "CALIFORNIA");
				Book book = new Book("TRIGON", 245.00);
				book.setPublisher(publisher);
				publisher.setBook(book);
				session.beginTransaction();
				session.save(book);
				session.save(publisher);
				session.getTransaction().commit();
			}else{
				session.beginTransaction();
				Book book = (Book) session.get(Book.class,1);
				Publisher publisher = (Publisher) session.get(Publisher.class,1);
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("book can give publisher and vice versa ,so this is ONE TO ONE ,BIDIRECTIONAL relationship\n");
				System.out.println("book details(book can give publisher):-");
				System.out.println("=====================================");
				System.out.println(book.getId() +"|"+ book.getBookName()  +"|"+ book.getCost() +"---->"+ book.getPublisher().getId() +"|"+ book.getPublisher().getPublisherName() +"|"+ book.getPublisher().getPublisherLoc()+"\n");
				
				System.out.println("publisher details(publisher can give book):-");
				System.out.println("============================================");
				System.out.println(publisher.getId() +"|"+ publisher.getPublisherName() +"|"+ publisher.getPublisherLoc() +"---->"+ publisher.getBook().getId() +"|"+ publisher.getBook().getBookName() +"|"+ publisher.getBook().getCost());
				session.getTransaction().commit();
			}			
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}
}
