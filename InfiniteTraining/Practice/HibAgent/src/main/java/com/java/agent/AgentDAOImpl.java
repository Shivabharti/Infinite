package com.java.agent;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AgentDAOImpl implements AgentDAO {

	SessionFactory sf;

	Session session;

	@Override
	public List<Agent> showAgentDao() {

		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Query query = session.createQuery("from Agent");

		List<Agent> agentList = query.list();

		return agentList;
	}

	@Override
	public Agent searchAgentDao(int agentId) {
		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Query query = session.createQuery("from Agent where agentId=" + agentId);

		List<Agent> agentList = query.list();

		if (agentList.size() > 0) {

			return agentList.get(0);

		}

		return null;
	}

	@Override
	public String addAgentDao(Agent agent) {
		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(agent);

		transaction.commit();

		return "Agent Record Inserted....";
	}

	@Override
	public String updateAgentDao(Agent agent) {
		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		session.update(agent);

		transaction.commit();

		return "Agent Record Updated....";
	}

	@Override
	public String deleteAgentDao(int agentId) {
		Agent AgentFound = searchAgentDao(agentId);

		if (AgentFound != null) {

			sf = SessionHelper.getConnection();

			session = sf.openSession();

			Transaction transaction = session.beginTransaction();

			session.delete(AgentFound);

			transaction.commit();

			return "Agent Record Deleted....";
		} return "Agent record not found";

	}
}
