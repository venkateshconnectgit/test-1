package com.yt.backendbeta.ServiceImpl;
import com.yt.backendbeta.Utility.ConnectorClass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.yt.backendbeta.Entity.Package;
import com.yt.backendbeta.Service.PackageInterface;

public class PackageImpl implements PackageInterface {

	public void addPackage(Package pack) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		session.save(pack);
		session.getTransaction().commit();
		session.close();	
	}

	public Package getPackageId(String packageId) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Package pack =(Package) session.get(Package.class, packageId);
		session.getTransaction().commit();
		session.close();	
		return pack;
	}

	public Package getPackageName(String name) {
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Package pack where pack.name = :Name");
		query.setString("Name", name);
		Package pack = (Package) query.uniqueResult();
		session.getTransaction().commit();
		session.close();	
		return pack;
	}

}
