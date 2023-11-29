package com.jsf.Agent;

import java.util.List;  

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class AgentDAOImpl implements AgentDAO{


	SessionFactory sf;
	Session session;
	public List<Agent> showAgentCr() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Agent.class);
		cr.addOrder(Order.asc("premium"));
		List<Agent> agentList = cr.list();
		return agentList;
	}
	public Agent searchAgentCr(int agentId) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Agent.class);
		cr.add(Restrictions.eq("agentId", agentId));
		Agent agent = (Agent) cr.uniqueResult();
		return agent; 
	}

	@Override
	public List<Agent> showAgentDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.createQuery("from Agent");
		List<Agent> agentList = query.list();
		return agentList;
	}

}
