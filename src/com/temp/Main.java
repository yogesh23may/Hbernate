package com.temp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("temp");
		/*Student student = new Student();//transient
		student.setName("Frodo");
		student.setGender("M");
		student.setAge(20);
		
		session.beginTransaction();
		session.save(student);//persistent
		session.getTransaction().commit();
		session.close();
		
		student.setName("Bilbo");//detached
		
		session = new HibernateUtil().getSession("temp");
		session.beginTransaction();
		Student s1 = (Student) session.get(Student.class,student.getId());
		Student s2 = (Student) session.merge(student);
		System.out.println(s1.hashCode() +"|"+s2.hashCode());
		session.getTransaction().commit();
		session.close();*/
		
		/*try{
		Student student1 = (Student) session.get(Student.class,1);
		student1.setAge(51);
		session = new HibernateUtil().getSession("temp");
		session.beginTransaction();
		Student student = (Student) session.get(Student.class,1);
		session.merge(student1);
		session.getTransaction().commit();
		session.close();
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
	
		session = new HibernateUtil().getSession("temp");
		session.beginTransaction();
		
		Student student = new Student();
		student.setName("Bilbo");
		student.setGender("M");
		student.setAge(22);
		
		Address address1 = new Address();address1.setCity("YEL");address1.setStudent(student);
		Address address2 = new Address();address2.setCity("YPR");address2.setStudent(student);
		List<Address> list = new ArrayList<Address>();list.add(address1);list.add(address2);
		
		student.setAddresses(list);
		session.save(student);session.save(address1);session.save(address2);
		
		session.getTransaction().commit();
		session.close();
		
		
		/*
		session = new HibernateUtil().getSession("temp");
		session.beginTransaction();
		Student stu = (Student) session.load(Student.class,1);//proxy created
		//stu.getAge();//loading proxy when lazy = true;when lazy = false :no proxy in role
		session.getTransaction().commit();
		session.close();
		System.out.println("age:"+stu.getAge());
		System.out.println("address:" + stu.getAddresses().get(0).getCity());//getting these becos of fetchType=EAGER
		*/
	}
}
