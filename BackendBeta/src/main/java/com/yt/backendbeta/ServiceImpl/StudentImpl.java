package com.yt.backendbeta.ServiceImpl;
import com.yt.backendbeta.Utility.ConnectorClass;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.yt.backendbeta.Entity.Student;
import com.yt.backendbeta.Service.StudentInterface;

public class StudentImpl implements StudentInterface{

	private Student student;
	 



	public void addStudent(Student student) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	public Student getStudentId(String studentId) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Student student = (Student) session.get(Student.class, studentId);
		session.getTransaction().commit();
		session.close();
		return student;
	}

	public List<Student> getAllStudent() {// TODO Auto-generated method stub
		SessionFactory connection = ConnectorClass.getConnection();
		Session session= connection.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Student");
		List<Student> student = query.list();
		session.getTransaction().commit();
		session.close();
		return student;
	}

	public List<Student> getStudentName(String name) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Student std where std.name = :name");
		query.setString("name", name);
		List<Student> student = query.list();
		session.getTransaction().commit();
		session.close();
		return student;
	}
        
}
