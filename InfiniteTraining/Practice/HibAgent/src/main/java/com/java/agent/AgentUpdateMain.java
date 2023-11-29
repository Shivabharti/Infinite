package com.java.agent;

import java.util.Scanner;

public class AgentUpdateMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Agent Agent= new Agent();
		System.out.println("Enter Agent Number");
		Agent.setAgentId(sc.nextInt());
		System.out.println("Enter Agent Name");
		Agent.setName(sc.next());
		System.out.println("Enter Agent City");
		Agent.setCity(sc.next());
		System.out.println("Enter Gender(MALE/FEMALE)");
		Agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Agent Marital Status");
		Agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter Agent Premium");
		Agent.setPremium(sc.nextDouble());
		AgentDAO dao= new AgentDAOImpl();
		System.out.println(dao.updateAgentDao(Agent));
	}
}
