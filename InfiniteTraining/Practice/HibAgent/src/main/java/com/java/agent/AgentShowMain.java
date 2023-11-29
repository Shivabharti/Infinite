package com.java.agent;

import java.util.List;

public class AgentShowMain {

	public static void main(String[] args) {
		AgentDAO dao= new AgentDAOImpl();
		List<Agent> agentList= dao.showAgentDao();
		for (Agent agent : agentList) {
			System.out.println(agent);
		}
	}
}
