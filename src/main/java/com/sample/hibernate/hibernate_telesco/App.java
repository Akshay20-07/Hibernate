package com.sample.hibernate.hibernate_telesco;

import org.hibernate.service.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AlienName aName=new AlienName();
    	aName.setfName("Akshay");
    	aName.setmName("Singh");
    	aName.setlName("Chauhan");
    	
        Alien alien=new Alien();
        alien.setaId(2);
        alien.setColor("Orange");
        alien.setalienName(aName);
        
        Configuration con =new Configuration().configure().addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf=con.buildSessionFactory(reg);
        
        Session session=sf.openSession();
        
        Transaction txn=session.beginTransaction();
        session.save(alien);
        /**
         * For Fetching the Values
         */
        //alien=(Alien) session.get(Alien.class,3);
        
        txn.commit();
        
        System.out.println(alien);
        
    }
}
