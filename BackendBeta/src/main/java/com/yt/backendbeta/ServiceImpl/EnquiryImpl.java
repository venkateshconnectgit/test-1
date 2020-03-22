package com.yt.backendbeta.ServiceImpl;
import com.yt.backendbeta.Utility.ConnectorClass;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yt.backendbeta.Entity.Course;
import com.yt.backendbeta.Entity.Enquiry;
import com.yt.backendbeta.Service.EnquiryInterface;

public class EnquiryImpl implements EnquiryInterface{

	public void addEnquiry(Enquiry enquiry) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		session.save(enquiry);
		session.getTransaction().commit();
		session.close();	
		
	}

	public Enquiry getEnquiryId(String id) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Enquiry enquiry =(Enquiry) session.get(Course.class, id);
		session.getTransaction().commit();
		session.close();	
		return enquiry;
	}

	public List<Enquiry> getEnquiryName(String name) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session s = connection.openSession();
		s.beginTransaction();
		Query q = s.createQuery("from Enquiry enq where name = :name");
		q.setString("name", name);
		List<Enquiry> e =(List<Enquiry>) q.list();
	    s.getTransaction().commit();
	    s.close();	
		return e;
	}
 
}
