package com.sample.hibernate.hibernate_postgres;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	
	public static void main(String[] args) {

		
		Configuration con= new Configuration().configure("/hibernate01.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session session=sf.openSession();
		session.beginTransaction();
/*		Random rn =new Random();
		
		for(int i=0;i<=50;i++){
			Student st=new Student();
			st.setMarks(i);
			st.setName(i+"Name");
			st.setMarks(rn.nextInt(100));
			session1.save(st);
		}*/
		
		Query q=session.createQuery("from Student where marks>50");
		List<Student> students=q.list();
		
		for(Student s:students){
			System.out.println(s);
		}
		
		session.getTransaction().commit();
		session.close();
		
		
	}
	


}
