package com.java.HMS1;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DoctorDAOImpl implements DoctorDAO{

	SessionFactory sf;
	Session session;
	@Override
	public List<Doctor_Master> showDoctorDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Doctor_Master.class);
		List<Doctor_Master> doctorList = criteria.list();
		return doctorList;
	}

	
}
