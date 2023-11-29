package com.java.agent;

import java.util.List;

public interface AgentDAO {
	List<Agent> showAgentDao();
	Agent searchAgentDao(int agentId);
	String addAgentDao(Agent agent);
	String deleteAgentDao(int agentId);
	String updateAgentDao(Agent agent);
}
