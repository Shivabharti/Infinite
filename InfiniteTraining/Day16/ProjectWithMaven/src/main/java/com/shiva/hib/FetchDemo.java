package com.shiva.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		//get and load
		Configuration cfg= new Configuration();
		cfg.configure();
		SessionFactory factory= cfg.buildSessionFactory();
		Session session= factory.openSession();
		
		//get student 101
		
		Address ad= (Address)session.get(Address.class,1);
		System.out.println(ad);
		
		Student student= (Student)session.load(Student.class, 103);
		System.out.println(student);
		
		
	}
}
