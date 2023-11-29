package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentUpdateMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Agent agent= new Agent();
		System.out.println("Enter Agent Id:");
		agent.setAgentId(sc.nextInt());
		System.out.println("Enter Agent Name:");
		agent.setName(sc.next());
		System.out.println("Enter City Name:");
		agent.setCity(sc.next());
		System.out.println("Enter Gender:");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Marital Status:");
		agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter Premium:");
		agent.setPremium(sc.nextDouble());
		
		AgentDAO dao= new AgentDAOImpl();
		try {
			System.out.println(dao.updateAgentDao(agent));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
