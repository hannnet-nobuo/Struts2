package jp.hannet.sample.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public enum DbAccess {
	INSTANCE ;
	private static SessionFactory sessionFactory;
	
	private static void getFactory() {
		
		final StandardServiceRegistry registry 
							= new StandardServiceRegistryBuilder()
									.configure()
									.build();
		try {
			sessionFactory = new MetadataSources( registry )
									.buildMetadata()
									.buildSessionFactory();
		}
		catch (Exception e) {
			StandardServiceRegistryBuilder.destroy( registry );
			throw new RuntimeException(e);
		}
	}
	
	public static Session getSession() {
		if (sessionFactory == null) {
			getFactory();
		}
		return sessionFactory.openSession();
	}
}
