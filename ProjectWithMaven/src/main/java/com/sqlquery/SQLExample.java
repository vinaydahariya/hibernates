package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.ProjectWithMaven.Student;

public class SQLExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		// SQL Query
		String q = "select *from student";
		
		NativeQuery nq = s.createSQLQuery(q);
		List<Object[]> list = nq.list();
		
		for(Object[] student : list) {
			System.out.println(Arrays.deepToString(student));
		}
		
		
		s.close();
		factory.close();
	}
}
