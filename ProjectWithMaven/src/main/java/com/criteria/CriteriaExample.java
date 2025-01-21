package com.criteria;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tut.ProjectWithMaven.Student;

public class CriteriaExample {
    public static void main(String[] args) {
        
     	Session s = new Configuration().configure().buildSessionFactory().openSession();
    	
        // Create CriteriaBuilder
        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        
        // Create CriteriaQuery
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(root);
        
        // Execute the query
        List<Student> students = s.createQuery(criteriaQuery).getResultList();
        
        // Print the results
        for (Student st : students) {
            System.out.println(st);
        }
        s.close();
    }
}
