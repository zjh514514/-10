package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import entities.Student;
import utils.HibernateTools;

@Repository
public class StudentDao extends HibernateTools {

	public List<Student> getAll() {
		String hql = "FROM Student";
		return getSession().createQuery(hql).list();
	}

	public void delete(Integer id) {
		String hql = "DELETE FROM Student s WHERE s.id = ?";
		getSession().createQuery(hql).setParameter(0, id).executeUpdate();
	}

	public void add(Student student) {
		getSession().saveOrUpdate(student);
	}

	public Student get(Integer id) {
		return getSession().get(Student.class, id);
	}

	public List<Student> query(String lastName, String firstName, String age) {
		String hql = "FROM Student s WHERE s.lastName LIKE :lastName AND s.firstName LIKE :firstName AND s.age LIKE :age";
		return getSession().createQuery(hql).setParameter("lastName", "%" + lastName + "%")
				.setParameter("firstName", "%" + firstName + "%").setParameter("age", "%" + age + "%").list();
	}
}
