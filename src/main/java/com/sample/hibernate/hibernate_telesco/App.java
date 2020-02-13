package com.sample.hibernate.hibernate_telesco;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * For simple hibernate connection
	 * fetching and Saving the name plus Use of Embeddable
	 * @param args
	 */
	/*public static void main(String[] args) {
		AlienName aName = new AlienName();
		aName.setfName("Akshay");
		aName.setmName("Singh");
		aName.setlName("Chauhan");

		Alien alien = new Alien();
		alien.setaId(2);
		alien.setColor("Orange");
		alien.setalienName(aName);

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg);

		Session session = sf.openSession();

		Transaction txn = session.beginTransaction();
		session.save(alien);
		*//**
		 * For Fetching the Values
		 *//*
		// alien=(Alien) session.get(Alien.class,3);

		txn.commit();

		System.out.println(alien);

	}*/
	
	public static void main(String[] args) {

		Laptop l1=new Laptop();
		l1.setLapId(100);
		l1.setLapName("Dell");
		
		Student stud1=new Student();
		stud1.setMarks(90);
		stud1.setRollNum(2);
		stud1.setName("Akshay");
		//stud1.setLap(l1);
		stud1.getLap().add(l1);
		l1.getStudent().add(stud1);
		Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		
		Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		
		session.save(l1);
		session.save(stud1);
		
		txn.commit();
		
		
	}
}
