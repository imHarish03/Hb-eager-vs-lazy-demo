package lab.basic.Hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lab.basic.Hibernate.demo.entity.Course;
import lab.basic.Hibernate.demo.entity.Instructor;
import lab.basic.Hibernate.demo.entity.InstructorDetail;

public class GetInstructorCourseDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				// Hibernate will load default file
				.configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();

			int id = 3;

			// Start transaction
			session.beginTransaction();
			Instructor instructor = (Instructor) session.get(Instructor.class, id);

			// Display Instructor name
			System.out.println("Instructor Name : " + instructor.getFirstName());
			System.out.println("Display courses : " + instructor.getCourse());
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			factory.close();
		}
	}
}
