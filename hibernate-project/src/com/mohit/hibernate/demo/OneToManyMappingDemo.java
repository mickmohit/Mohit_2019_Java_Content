package com.mohit.hibernate.demo;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.mapping.Instructor;
import com.mohit.hibernate.mapping.InstructorDetail;
import com.mohit.hibernate.mapping.OnetoMany.Course;

public class OneToManyMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory2 = new Configuration().
										configure("hibernateOneToManyMapping.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		//Session session1= sessionFactory1.getCurrentSession();
		Session session2 = sessionFactory2.openSession();
	
		Transaction tx = null;
		try {
			
			/*Instructor instructor = new Instructor("Mukesh", "Pandey", "mohit.Pandey@sita.aero");
			InstructorDetail instructorDetail = new InstructorDetail("GoogleNews", "Data Analytics");
			//associate objects
			instructor.setInstructorDetail(instructorDetail);*/
			
			tx=session2.beginTransaction();
			 Instructor instructor= session2.get(Instructor.class, 1);
			
			Course course1= new Course("SAP");
			Course course2= new Course("SQL");
			
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			
			
			
			session2.save(course1);
			session2.save(course2);
			
			//session2.beginTransaction().commit();
			 tx.commit();
			 
			 
		}
		catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     throw e;
		 }
		finally {
			/*session2.flush();
			session2.close();*/
			sessionFactory2.close();
		}
	}

}
