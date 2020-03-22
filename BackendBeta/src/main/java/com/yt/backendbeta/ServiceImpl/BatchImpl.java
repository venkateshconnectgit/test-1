package com.yt.backendbeta.ServiceImpl;
import com.yt.backendbeta.Utility.ConnectorClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.yt.backendbeta.Entity.Batch;

import com.yt.backendbeta.Service.BatchInterface;



public class BatchImpl implements BatchInterface{

	public void createBatch(Batch batch) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session= connection.openSession();
		session.beginTransaction();
		session.save(batch);
	    session.getTransaction().commit();
	    session.close();		
	}

}
