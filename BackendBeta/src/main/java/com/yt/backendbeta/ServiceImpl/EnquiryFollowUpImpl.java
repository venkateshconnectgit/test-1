package com.yt.backendbeta.ServiceImpl;
import com.yt.backendbeta.Utility.ConnectorClass;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.yt.backendbeta.Entity.EnquiryFollowUp;
import com.yt.backendbeta.Service.EnquiryFollowUpInterface;

public class EnquiryFollowUpImpl implements EnquiryFollowUpInterface{

	public void addEnquiryFollowUp(EnquiryFollowUp enquiryFollowUp) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		session.save(enquiryFollowUp);
	    session.getTransaction().commit();
	    session.close();			
	}

	public EnquiryFollowUp getEnquiryFollowUp(String id) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		EnquiryFollowUp enquiryFollowUp = (EnquiryFollowUp) session.get(EnquiryFollowUp.class, id);
		session.getTransaction().commit();
		session.close();	
		return enquiryFollowUp;
	}
}
