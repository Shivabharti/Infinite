package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AgentBeanRemote {

	List<Agent> showAgentDao() throws ClassNotFoundException, SQLException;
	Agent searchAgent(int agentId) throws ClassNotFoundException, SQLException;
	String addAgent(Agent Agent) throws ClassNotFoundException, SQLException;
	String deleteAgent(int agentId) throws ClassNotFoundException, SQLException;
	String updateAgent(Agent Agent) throws ClassNotFoundException, SQLException;
	}
