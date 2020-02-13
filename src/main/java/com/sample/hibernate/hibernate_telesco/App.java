package com.sample.hibernate.hibernate_telesco;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien alien=new Alien();
        alien.setaId(1);
        alien.setaName("Akshay");
        alien.setColor("blue");
        
        Configuration con =new Configuration().configure().addAnnotatedClass(Alien.class);
        
        SessionFactory sf=con.buildSessionFactory();
        
        Session session=sf.openSession();
        
        Transaction txn=session.beginTransaction();
        session.save(alien);
        
        txn.commit();
        
    }
}
