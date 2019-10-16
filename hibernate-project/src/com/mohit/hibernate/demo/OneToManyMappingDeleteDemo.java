package com.mohit.hibernate.demo;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.mapping.Instructor;
import com.mohit.hibernate.mapping.InstructorDetail;
import com.mohit.hibernate.mapping.OnetoMany.Course;

public class OneToManyMappingDeleteDemo {

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
			 Course courseDelete= session2.get(Course.class, 11);
			
			 session2.delete(courseDelete);
			
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
