package com.java.ejb;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class AgentEjbImpl {

	public List<Agent> showAgentEjb() throws NamingException, ClassNotFoundException, SQLException{
		AgentBeanRemote remote= RemoteHelper.lookupRemoteStatelessAgent();
		return remote.showAgentDao();
	}
	public String searchAgentEjb(int agentId) throws NamingException, ClassNotFoundException, SQLException {
		AgentBeanRemote remote= RemoteHelper.lookupRemoteStatelessAgent();
		Agent agent = remote.searchAgent(agentId);
		Map<String, Object> sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("editAgent", agent);
		return "UpdateAgent.jsp?faces-redirect=true";
	}
	public String updateAgentEjb(Agent AgentNew) throws NamingException, ClassNotFoundException, SQLException {
		AgentBeanRemote remote= RemoteHelper.lookupRemoteStatelessAgent();
		remote.updateAgent(AgentNew);
		return "AgentDaoTable.jsp?faces-redirect=true";
	}
	public String deleteAgentEjb(int agentId) throws NamingException, ClassNotFoundException, SQLException {
		AgentBeanRemote remote= RemoteHelper.lookupRemoteStatelessAgent();
		remote.deleteAgent(agentId);
		return "AgentDaoTable.jsp?faces-redirect=true";
	}
	public String addAgentEjb(Agent Agent) throws NamingException, ClassNotFoundException, SQLException {
		AgentBeanRemote remote= RemoteHelper.lookupRemoteStatelessAgent();
		remote.addAgent(Agent);
		return "AgentDaoTable.jsp?faces-redirect=true";
	}
}
