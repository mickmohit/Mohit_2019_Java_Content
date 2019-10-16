package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().
										configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		
		try {
			Student student= new Student("Ambrish", "Pandya", "ambrish.pandya@sita.aero");
			
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		
			
			session= sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student myStudent=session.get(Student.class, student.getId());
			
			System.out.print(myStudent);
			session.getTransaction().commit();
		}
		finally {
			sessionFactory.close();
		}
	}

}
