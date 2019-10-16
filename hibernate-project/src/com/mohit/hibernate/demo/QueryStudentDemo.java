package com.mohit.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().
										configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		
		try {
		

			session.beginTransaction();
			List<Student> theStudent=session.createQuery("from Student").getResultList();
			
			displayStudents(theStudent);
			System.out.println("\n");
			
			List<Student> theStudent1=session.createQuery("from Student s where s.lastName='Pandey'"
					+ "OR s.firstName='Mukesh'").getResultList();
			
			displayStudents(theStudent1);
			
			session.getTransaction().commit();
		}
		finally {
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> theStudent1) {
		for(Student st: theStudent1)
		System.out.println(st);
	}
}
