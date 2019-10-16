package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.mapping.Instructor;
import com.mohit.hibernate.mapping.InstructorDetail;
import com.mohit.hibernate.mapping.OnetoMany.Course;
import com.mohit.hibernate.mapping.OnetoMany.Review;

public class OneToManyMappingUniDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory2 = new Configuration().
										configure("hibernateOneToManyMappingUni.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.buildSessionFactory();
		
		//Session session1= sessionFactory1.getCurrentSession();
		Session session2 = sessionFactory2.openSession();
	
		Transaction tx = null;
		try {
			
			tx=session2.beginTransaction();
			 
			
			Course course1= new Course("JAVA");
			Course course2= new Course("C#");
			
			
			course1.addReview(new Review("Great"));
			course2.addReview(new Review("Cool"));
			
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
