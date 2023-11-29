package com.java.agent;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetInternalMethods;

public class AgentDAOImpl implements AgentDAO{
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Agent> showAgentDao() throws ClassNotFoundException, SQLException {
		connection= AgentConnectionHelper.getConnection();
		String cmd= "Select * from Agent";
		pst= connection.prepareStatement(cmd);
		ResultSet rs= pst.executeQuery();
		List<Agent> agentList= new ArrayList<Agent>();
		Agent agent=null;
		while(rs.next()) {
			agent= new Agent();
			agent.setAgentId(rs.getInt("agentId"));
			agent.setName(rs.getString("name"));
			agent.setCity(rs.getString("city"));
			agent.setGender(Gender.valueOf(rs.getString("gender")));
			agent.setMaritalStatus(rs.getInt("maritalStatus"));
			agent.setPremium(rs.getDouble("premium"));
			agentList.add(agent);
		}
		return agentList;
		
	}

	@Override
	public Agent searchAgentDao(int agentId) throws ClassNotFoundException, SQLException {
		connection=AgentConnectionHelper.getConnection();
		String cmd= "Select * from Agent where agentId=?";
		pst= connection.prepareStatement(cmd);
		pst.setInt(1, agentId);
		ResultSet rs= pst.executeQuery();
		Agent agent= null;
		while(rs.next()) {
			agent= new Agent();
			agent.setAgentId(rs.getInt("agentId"));
			agent.setName(rs.getString("name"));
			agent.setCity(rs.getString("city"));
			agent.setGender(Gender.valueOf(rs.getString("gender")));
			agent.setMaritalStatus(rs.getInt("maritalStatus"));
			agent.setPremium(rs.getDouble("premium"));
			
		}
		return agent;
	}

	@Override
	public String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException {
		connection=AgentConnectionHelper.getConnection();
		String cmd= "Insert into Agent(AgentId,name,city,gender,maritalStatus,Premium)"+" values(?,?,?,?,?,?)";
		pst= connection.prepareStatement(cmd);
		pst.setInt(1,agent.getAgentId());
		pst.setString(2,agent.getName());
		pst.setString(3,agent.getCity());
		pst.setString(4,agent.getGender().toString());
		pst.setInt(5,agent.getMaritalStatus());
		pst.setDouble(6,agent.getPremium());
		pst.executeUpdate();
		return "Agent Record Inserted";
		
	}

	@Override
	public String deleteAgentDao(int agentId) throws ClassNotFoundException, SQLException {
		Agent agent= searchAgentDao(agentId);
		if(agent!=null) {
			connection=AgentConnectionHelper.getConnection();
			String cmd= "Delete from agent where agentId=?";
			pst= connection.prepareStatement(cmd);
			pst.setInt(1, agentId);
			pst.executeUpdate();
			return "Agent Record deleted";
		}else {
			return "Record not found";
		}
		
	}

	@Override
	public String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException {
		Agent agentFound= searchAgentDao(agentNew.getAgentId());
		if(agentFound!=null) {
			connection= AgentConnectionHelper.getConnection();
			String cmd="Update Agent set name=?, city=?, gender=?,maritalStatus=?, Premium=?";
			pst= connection.prepareStatement(cmd);
			pst.setString(1,agentNew.getName());
			pst.setString(2, agentNew.getCity());
			pst.setString(3, agentNew.getGender().toString());
			pst.setInt(4, agentNew.getMaritalStatus());
			pst.setDouble(5, agentNew.getPremium());
			
			pst.executeUpdate();
			return "Agent Record Updated";
		}else {
			return "Agent id not found";
		}
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
