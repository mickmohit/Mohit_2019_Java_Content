package com.mohit.hibernate.demo;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.mapping.Instructor;
import com.mohit.hibernate.mapping.InstructorDetail;

public class MappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory2 = new Configuration().
										configure("hibernateMapping.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		//Session session1= sessionFactory1.getCurrentSession();
		Session session2 = sessionFactory2.openSession();
	
		Transaction tx = null;
		try {
			
			Instructor instructor = new Instructor("Ambrish", "Pandya", "mohit.darmwal@sita.aero");
			InstructorDetail instructorDetail = new InstructorDetail("Twitter", "Travelling");
			
			//associate objects
			instructor.setInstructorDetail(instructorDetail);
			
			tx=session2.beginTransaction();
			session2.save(instructor);
			
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
