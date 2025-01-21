package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Student;

public class HQLExample {
	public static void main(String[] args) {
		// SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session s = factory.openSession();
        
        // HQL
        //Syntax
        //
//        String query = "from Student where city = 'jaipur'";
        String query = "from Student where city = :x";
        
        Query q = s.createQuery(query);
        
        q.setParameter("x", "jaipur");
        
        //single - (Unique)
        //multiple - list
        List<Student> list = q.list();
        
        for(Student student : list) {
        	System.out.println(student.getName());
        }
        
        System.out.println("______________________________________________________________");
        
        Transaction tx = s.beginTransaction();
//        delete Query
//        Query q2 = s.createQuery("delete from Student s where s.city = :c");
//        q2.setParameter("c", "BHOPAL");
//        int r = q2.executeUpdate();
//        System.out.println("deleted : ");
//        System.out.println(r);
        
        Query q2 = s.createQuery("update Student set city=:c where name=:n");
        q2.setParameter("c", "dubai");
        q2.setParameter("n", "Rohit Tiwari");
        int r = q2.executeUpdate();
        System.out.println(r + " objects updated");
        
        tx.commit();
        
//        how to execute join query
       Query q3 = s.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answers as a ");
       List<Object[]> list3 = q3.getResultList();
       for(Object[] arr : list3) {
    	   System.out.println(Arrays.toString(arr));
       }
        
        s.close();
        
        factory.close();
	}
}
