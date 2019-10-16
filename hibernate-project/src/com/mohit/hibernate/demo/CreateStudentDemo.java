package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().
										configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		
		try {
			Student student= new Student("Anshul", "Agrawal", "anshul.agrawal@sita.aero");
			Student student1= new Student("Mukesh", "Pandey", "mukesh.pandey@sita.aero");
			session.beginTransaction();
			session.save(student1);
			session.getTransaction().commit();
			session.close();
		}
		finally {
			sessionFactory.close();
		}
	}

}
