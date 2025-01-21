package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        // first student
        Student student1 = new Student();
        student1.setSid(128);
        student1.setName("Antima");
        student1.setCity("LKO");
        
        Certificate certificate = new Certificate();
        certificate.setCourse("Android");
        certificate.setDuration("2 months");
        student1.setCerti(certificate);
        
        // second student
        Student student2 = new Student();
        student2.setSid(635);
        student2.setName("Roshni");
        student2.setCity("BHOPAL");
        
        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Ios");
        certificate1.setDuration("3 months");
        student2.setCerti(certificate1);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        //object save:
        s.save(student1);
        s.save(student2);
        
        tx.commit();
        s.close();
        
	}
}
