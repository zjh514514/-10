package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StudentDao;
import entities.Student;

class Test {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	StudentDao studentDao = new StudentDao();

	@org.junit.jupiter.api.Test
	public void test() {
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		String lastName = "";
		String firstName = "";
		String age = "10";
		String hql = "FROM Student s WHERE s.lastName LIKE :lastName AND s.firstName LIKE :firstName AND s.age LIKE :age";

		List<Student> students = session.createQuery(hql).setParameter("lastName", "%" + lastName + "%")
				.setParameter("firstName", "%" + firstName + "%").setParameter("age", "%" + age + "%").list();
		System.out.println(students);
	}

}
