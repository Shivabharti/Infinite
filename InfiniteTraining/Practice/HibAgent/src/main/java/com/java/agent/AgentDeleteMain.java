package com.java.agent;

import java.util.Scanner;

public class AgentDeleteMain {

	public static void main(String[] args) {
		int agentId;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Agent Id:");
		agentId= sc.nextInt();
		AgentDAO dao= new AgentDAOImpl();
		System.out.println(dao.deleteAgentDao(agentId));
		
	}
}
