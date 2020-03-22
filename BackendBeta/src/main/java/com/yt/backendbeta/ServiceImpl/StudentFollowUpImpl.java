package com.yt.backendbeta.ServiceImpl;
import com.yt.backendbeta.Utility.ConnectorClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.yt.backendbeta.Entity.StudentFollowUp;
import com.yt.backendbeta.Service.StudentFollowUpInteface;

public class StudentFollowUpImpl implements StudentFollowUpInteface{

	public void addStudentFollowUpInteface(StudentFollowUp student) {
	    
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();	
	}

}
