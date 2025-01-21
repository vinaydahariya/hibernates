package com.tut.ProjectWithMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Project started..");
        // SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        // creating student
        Student st = new Student();
        st.setSid(103);
        st.setName("legend");
        st.setCity("jaipur");
        
        // creating object of address class
        Address ad = new Address();
        ad.setStreet("street5 ");
        ad.setCity("lucknow");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(125.213);
        
        // Reading image
        FileInputStream fis = new FileInputStream("src/main/java/telephone.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("done..");
    }
}
