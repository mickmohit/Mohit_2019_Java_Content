package com.mohit.hibernate.demo;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.mapping.Instructor;
import com.mohit.hibernate.mapping.InstructorDetail;

public class MappingDeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory2 = new Configuration().
										configure("hibernateMapping.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		//Session session1= sessionFactory1.getCurrentSession();
		Session session2 = sessionFactory2.getCurrentSession();
	
		Transaction tx = null;
		try {
			
		
		/*	//for deletion from Instructor to InstructorDetail
			tx=	session2.beginTransaction();
			Instructor instructor=session2.get(Instructor.class,1);

			if(instructor!=null)
				session2.delete(instructor);
			//session2.beginTransaction().commit();
			 tx.commit();*/
			 
			//for deletion from InstructorDetail to Instructor
				tx=	session2.beginTransaction();
				InstructorDetail instructorDetail=session2.get(InstructorDetail.class,2);

				if(instructorDetail!=null)
					session2.delete(instructorDetail);
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
