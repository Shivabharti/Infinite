package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AgentBean
 */
@Stateless
@Remote(AgentBeanRemote.class)
public class AgentBean implements AgentBeanRemote {

static AgentDAO daoImpl;
	
	static {
		daoImpl= new AgentDAOImpl();
	}
    /**
     * Default constructor. 
     */
    public AgentBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Agent> showAgentDao() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.showAgentDao();
	}

	@Override
	public Agent searchAgent(int agentId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.searchAgentDao(agentId);
	}

	@Override
	public String addAgent(Agent Agent) throws ClassNotFoundException, SQLException {
		return daoImpl.addAgentDao(Agent);

	}

	@Override
	public String deleteAgent(int agentId) throws ClassNotFoundException, SQLException {
		return daoImpl.deleteAgentDao(agentId);
	}

	@Override
	public String updateAgent(Agent Agent) throws ClassNotFoundException, SQLException {
		return daoImpl.updateAgentDao(Agent);
	}


}
