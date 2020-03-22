package com.yt.backendbeta.ServiceImpl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.yt.backendbeta.Entity.Course;
import com.yt.backendbeta.Service.CourseInterface;
import com.yt.backendbeta.Utility.ConnectorClass;

public class CourseImpl implements CourseInterface{

	public void addCourse(Course course) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		session.save(course);
	    session.getTransaction().commit();
	    session.close();		
	}
	public int getCourseId(String course) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select cr.id from Course cr where courseName=:name");
		query.setParameter("name", course);
		int id = (Integer) query.uniqueResult();
	    session.getTransaction().commit();
	    session.close();
	    return id;
	}
	public Course getCourseObject(String course) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Course cr where courseName=:name");
		query.setParameter("name", course);
		Course crs = (Course) query.uniqueResult();
	    session.getTransaction().commit();
	    session.close();
	    return crs;
	}

}
