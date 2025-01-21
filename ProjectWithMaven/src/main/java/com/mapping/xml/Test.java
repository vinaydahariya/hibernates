package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        // Initialize Hibernate session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        // Create a new Person object
        Person person = new Person(23, "Ram", "Delhi", "7007338198");
        
        // Open a new session
        Session session = factory.openSession();
        
        // Start a transaction
        Transaction tx = session.beginTransaction();
        
        // Save the person object
        session.save(person);
        
        // Commit the transaction
        tx.commit();
        
        // Close the session
        session.close();
        
        // Close the session factory
        factory.close();
    }
}
