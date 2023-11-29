package com.java.HMS1;

import java.util.Random; 

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class PatientDaoImpl {
//	public static int generateOtp() {
//		Random r = new Random(System.currentTimeMillis());
//		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
//	}

	SessionFactory sf;
	Session session;

	public String AddPatient(Patient_Master patient) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		int otp = GenerateOtp.generateOtp();
		patient.setOtp(otp);
		session.save(patient);
		transaction.commit();

		String body = "Welcome to Minu Health Center " + patient.getName() + "\r\n" + "Your one time password is "
				+ "\r\n" + "OTP:" + otp+ " Do not share this otp with anyone";
		MailSend.mailOtp(patient.getEmail(), "Otp Send Succesfully...", body);
		return "VerifyOtp.jsp?faces-redirect=true";
	}
	
	public String otpVerification(Patient_Master patient ) {
		sf= SessionHelper.getConnection();
		session= sf.openSession();
		Criteria cr= session.createCriteria(Patient_Master.class);
		cr.add(Restrictions.eq("name", patient.getName()));
		cr.add(Restrictions.eq("otp", patient.getOtp()));
		cr.setProjection(Projections.rowCount());
		long count=(long)cr.uniqueResult();
		if(count==1) {
			return "ResetPassword.jsp?faces-redirect=true";
		}else {
			return "ShowDoctor.jsp?faces-redirect=true";
		}
	}
}