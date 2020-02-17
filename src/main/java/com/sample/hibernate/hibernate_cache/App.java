package com.sample.hibernate.hibernate_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		
		AlienCache a=null;
		
		Configuration con= new Configuration().configure().addAnnotatedClass(AlienCache.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session session1=sf.openSession();
		session1.beginTransaction();
		
		a=(AlienCache) session1.get(AlienCache.class, 2);
		System.out.println(a.toString());
		session1.getTransaction().commit();
		session1.close();
		
		Session session2=sf.openSession();
		session2.beginTransaction();
		a=(AlienCache) session2.get(AlienCache.class, 2);
		System.out.println(a.toString());
		
		session2.getTransaction().commit();
		session2.close();
	}
	


}
