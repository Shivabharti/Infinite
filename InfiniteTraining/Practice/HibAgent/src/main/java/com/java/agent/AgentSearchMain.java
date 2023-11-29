package com.java.agent;

import java.util.Scanner;


public class AgentSearchMain {

	public static void main(String[] args) {
		int agentId;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Agent Number");
		agentId=sc.nextInt();
		AgentDAO dao= new AgentDAOImpl();
		Agent agent= dao.searchAgentDao(agentId);
		if(agent!=null) {
			System.out.println(agent);
		}
	}
}
