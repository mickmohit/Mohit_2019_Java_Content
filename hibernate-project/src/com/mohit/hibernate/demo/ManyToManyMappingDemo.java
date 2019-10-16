package com.mohit.hibernate.demo;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Student;
import com.mohit.hibernate.mapping.Instructor;
import com.mohit.hibernate.mapping.InstructorDetail;
import com.mohit.hibernate.mapping.OnetoMany.Course;
import com.mohit.hibernate.mapping.OnetoMany.Review;

public class ManyToManyMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory2 = new Configuration().
										configure("hibernateManyToManyMapping.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Student.class)
										.addAnnotatedClass(Review.class)
										.buildSessionFactory();
		
		Session session2= sessionFactory2.getCurrentSession();
		//Session session2 = sessionFactory2.openSession();
	
		Transaction tx = null;
		try {
			
			
			
			tx=session2.beginTransaction();
		/*	
			Instructor i = new Instructor("abc", "def", "ad");
			session2.save(i);
			
			InstructorDetail id= new InstructorDetail("as", "dfss");
			session2.save(id);
			*/
	
			System.out.println("************************************");
			Course course=new Course("Wakow Trainning");
	/*		i.addCourse(course);*/
		
			session2.save(course);
			System.out.println("=================================>"+course);
			System.out.println("***********||||||||||||||||||||||||||||*************************");
			Student student= new Student("Mary", "Public", "mary.public@gmail.com");
			Student student1= new Student("John", "Doe", "john.doe@gmail.com");
			
			System.out.println("$$$$$$$$$$$$$$$$====>"+student);
			/*student.setId(1);
			student1.setId(2);*/
			
			System.out.println("############################################===>"+student);
			
			
			course.addStudent(student);
			
			course.addStudent(student1);
			
			session2.save(student);

			session2.save(student1);
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
