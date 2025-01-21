package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map1.Answer;
import com.map1.Question;

public class CascadeExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Question q1 = new Question();
		
		q1.setQuestionId(568);
		q1.setQuestion("What is swing framework");
		
		Answer a1 = new Answer(726, "Used for desktop gui");
		Answer a2 = new Answer(727, "FX is replaced by swing");
		Answer a3 = new Answer(728, "some awt component are used here");
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		Transaction tx = s.beginTransaction();
		
		s.save(q1);
		s.save(a1);
		s.save(a2);
		s.save(a3);
		
		tx.commit();
		s.close();
		factory.close();
	}
}
