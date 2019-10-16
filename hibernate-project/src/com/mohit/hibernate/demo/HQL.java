package com.mohit.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mohit.hibernate.mapping.Instructor;
import com.mohit.hibernate.mapping.InstructorDetail;
import com.mohit.hibernate.mapping.OnetoMany.Course;

public class HQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory2 = new Configuration().
										configure("hibernateMapping.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		//Session session1= sessionFactory1.getCurrentSession();
		Session session2 = sessionFactory2.getCurrentSession();
	
		Transaction tx = null;
		try {
			
			tx=session2.beginTransaction();
			
			Query<Course> query =session2.createQuery("select c from Course c "
                    + "where c.instructor.id=:theInstructorId",    
                    Course.class);

			query.setParameter("theInstructorId", 3);

			
			List<Course> instructor=query.getResultList();
			
			for(Course i:instructor)
			{
				System.out.println(i.getInstructor());
			}
			
			session2.getTransaction().commit();
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

