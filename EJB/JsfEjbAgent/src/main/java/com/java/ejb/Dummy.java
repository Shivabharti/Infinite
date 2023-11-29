package com.java.ejb;

 

import java.sql.SQLException;

import javax.naming.NamingException;

 

public class Dummy {

	

	public static void main(String[] args) {

		try {

			System.out.println(new AgentEjbImpl().showAgentEjb());

		} catch (ClassNotFoundException | SQLException | NamingException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

 

}