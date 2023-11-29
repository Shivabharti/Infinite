package com.java.hibnew;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.hibernate.criterion.Order;

import org.hibernate.criterion.Restrictions;

public class EmployDAOImpl implements EmployDAO {

	SessionFactory sf;

	Session session;

	@Override

	public List<Employ> showEmployDao() {

		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Query query = session.createQuery("from Employ");

		List<Employ> employList = query.list();

		return employList;

	}

	public List<Employ> showEmployCr() {

		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Criteria cr = session.createCriteria(Employ.class);

		cr.addOrder(Order.asc("basic"));

		List<Employ> employList = cr.list();

		return employList;

	}

	public Employ searchEmploy(int empno) {

		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Criteria cr = session.createCriteria(Employ.class);

		cr.add(Restrictions.eq("empno", empno));

		Employ employ = (Employ) cr.uniqueResult();

		return employ;

	}

	@Override

	public Employ searchEmployDao(int empno) {

		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Query query = session.createQuery("from Employ where empno=" + empno);

		List<Employ> employList = query.list();

		if (employList.size() > 0) {

			return employList.get(0);

		}

		return null;

	}

	@Override

	public String addEmployDao(Employ employ) {

		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(employ);

		transaction.commit();

		return "Employ Record Inserted....";

	}

	@Override

	public String deleteEmployDao(int empno) {

		Employ employFound = searchEmployDao(empno);

		if (employFound != null) {

			sf = SessionHelper.getConnection();

			session = sf.openSession();

			Transaction transaction = session.beginTransaction();

			session.delete(employFound);

			transaction.commit();

			return "Employ Record Deleted....";

		}

		return "Employ Record Not Found...";

	}

}