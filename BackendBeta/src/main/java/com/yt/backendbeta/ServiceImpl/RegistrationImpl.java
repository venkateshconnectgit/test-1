package com.yt.backendbeta.ServiceImpl;
import com.yt.backendbeta.Utility.ConnectorClass;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yt.backendbeta.Entity.Registration;
import com.yt.backendbeta.Service.RegistrationInterface;

public class RegistrationImpl implements RegistrationInterface{

	public void addRegistration(Registration reg) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		session.save(reg);
		session.getTransaction().commit();
		session.close();
	
	}

	public Registration getRegistrationId(String registrationId) {
		
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Registration r =(Registration) session.get(Registration.class, registrationId);
		session.getTransaction().commit();
		session.close();
		return r;
	}

	public List<Registration> getAllRegistration() {

		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Registration");
		List<Registration> reg = query.list();
		session.getTransaction().commit();
		session.close();
		return reg;
	}

	public List<Registration> getRegistrationName(String name) {
	
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Registration reg where reg.name=:n");
		query.setString("n", name);
		List <Registration> reg = query.list();
		session.getTransaction().commit();
		session.close();
		return reg;
	}

}
