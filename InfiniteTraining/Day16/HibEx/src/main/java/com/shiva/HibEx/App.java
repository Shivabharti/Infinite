package com.shiva.HibEx;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		Alien shiva = new Alien();
		shiva.setaId(101);
		shiva.setaName("Shivangi");
		shiva.setColor("Green");

		Configuration con= new Configuration().configure();
		SessionFactory sf= con.buildSessionFactory();
		Session session = sf.openSession();
	    session.save(shiva);
	}

}
