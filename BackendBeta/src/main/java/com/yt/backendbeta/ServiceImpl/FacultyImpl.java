package com.yt.backendbeta.ServiceImpl;
import com.yt.backendbeta.Utility.ConnectorClass;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.yt.backendbeta.Entity.Faculty;
import com.yt.backendbeta.Service.FacultyInterface;

public class FacultyImpl implements FacultyInterface {

	public void addFaculty(Faculty faculty) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		session.save(faculty);
		session.getTransaction().commit();
		session.close();	

	}

	public Faculty getFacultyId(String facultyId) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Faculty faculty =(Faculty) session.get(Faculty.class, facultyId);
		session.getTransaction().commit();
		session.close();	
		return faculty;
	}

	public List<Faculty> getFacultyName(String name) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Faculty fac where fac.name = :name");
		query.setString("name", name);
		List<Faculty> faculty = query.list();
		session.getTransaction().commit();
		session.close();	
		return faculty;
	}

}
