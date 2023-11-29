package com.java.agent;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentDeleteMain {

	public static void main(String[] args) {
		int agentId;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Agent Id:");
		agentId= sc.nextInt();
		AgentDAO dao= new AgentDAOImpl();
		try {
			System.out.println(dao.deleteAgentDao(agentId));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
