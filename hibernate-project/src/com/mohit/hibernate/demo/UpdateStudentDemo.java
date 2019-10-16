package com.mohit.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().
										configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session= sessionFactory.getCurrentSession();
		
		try {
		

			session.beginTransaction();
			int studentId=1;
			Student student= session.get(Student.class,studentId);
			
			System.out.println("\n");
			
			session.createQuery("update Student set email="
					+ "'mohit.mohit@gmail.com' where id="+studentId).executeUpdate();
			
			System.out.println("done");
			
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
