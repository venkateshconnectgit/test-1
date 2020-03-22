package com.yt.backendbeta.ServiceImpl;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.yt.backendbeta.Entity.Price;

import com.yt.backendbeta.Service.PriceInterface;
import com.yt.backendbeta.Utility.ConnectorClass;

public class PriceImpl implements PriceInterface{

	public void addPrice(Price price) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		session.save(price);
		session.getTransaction().commit();
		session.close();	
	}

	public void updateTax(int tax) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Price set percentTax = :newPercentTax");
        query.setParameter("newPercentTax", tax);
        query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}

	public Price getPrice(String courseOrPackage) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
	    		
		Query query = session.createQuery("from Price where courseOrPackage=:n");
		query.setString("n", courseOrPackage);
		Price price=(Price) query.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return price;
	}

}
