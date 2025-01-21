package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Certificate;
import com.tut.ProjectWithMaven.Student;

public class StateDemo {
	public static void main(String[] args) {
		//Practical of Hibernate objects states:
		//Transient
		//Persistent
		//Detached
		//Removed
		System.out.println("Example :");
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		// Creating Student object
		Student student = new Student();
		student.setSid(1414);
		student.setName("Peter");
		student.setCity("ABC");
		student.setCerti(new Certificate("Java hibernate course", "2 month"));
		//student : Transient
		
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		//student : Persistent - session, database
		student.setName("John");
		
		tx.commit();
		s.close();
		
		//student : Detached
		student.setName("shivang");
		System.out.println(student);
		
		f.close();
	}
}
