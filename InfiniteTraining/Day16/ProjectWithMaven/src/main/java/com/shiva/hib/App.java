package com.shiva.hib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

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
        System.out.println( "Project started" );
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        //Creating Student
        
        Student st= new Student();
        st.setId(103);
        st.setName("Shila");
        st.setCity("Jharkhand");
        System.out.println(st);
     
        // Creating object of address class
        
        Address ad= new Address();
        ad.setStreet("Street1 ");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(120.487);
        
        //reading Imange
        try {
			FileInputStream fis= new FileInputStream("src/main/java/shiva.jpg");
			 byte[]  data= new byte[fis.available()];
			 fis.read();
			 ad.setImage(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        
        //another way
        //SessionFactory factory = new Configuration().configure().buildSessionFactory();
    }
}
