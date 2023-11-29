package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAgentMain {

	public static void main(String[] args) {
		int agentId;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter AgenteId:");
		agentId= sc.nextInt();
		AgentDAO dao= new AgentDAOImpl();
		try {
			Agent agent= dao.searchAgentDao(agentId);
			if(agent!=null) {
				System.out.println(agent);
			}else {
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
