package com.sample.hibernate.hibernate_postgres;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		
		//HQL Queries
/*		Query q=session.createQuery("from Student where marks>50");
		List<Student> students=q.list();
		
		for(Student s:students){
			System.out.println(s);
		}
		
		int b=50;
		Query q1=session.createQuery("select sum(marks) from Student where marks > :b");
		q1.setParameter("b",b);
		Long marks=(Long) q1.uniqueResult();
		
		System.out.println(marks);
		session.getTransaction().commit();
		session.close();*/
		
		//Native Queries
		SQLQuery q=session.createSQLQuery("select * from Student where marks >60");
		q.addEntity(Student.class);
		List<Student> st=q.list();
		
		for(Student s:st){
			System.out.println(s);
		}
		
		SQLQuery q2=session.createSQLQuery("select name,marks from Student where marks >60 ");
		q2.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List st2=q2.list();
		
		for(Object s:st2){
			Map m=(Map)s;
			System.out.println(m.get("name")+ ":"+m.get("marks"));
		}
	}
	


}
