package com.yt.backendbeta.Utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class ConnectorClass {
  public static SessionFactory getConnection() {
	  Configuration configuration =  new Configuration();
	  configuration.configure("/hibernate.cfg.xml");
	  ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	  SessionFactory session = configuration.buildSessionFactory(reg);
	  return session;
  }
}
