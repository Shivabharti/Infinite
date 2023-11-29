package com.java.hms;

import java.util.Map;

import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class HmsDAOImpl implements HmsDAO {

	SessionFactory sf;
	Session session;

	@Override
	public String showInsuranceRequest(int claim_Id) {
		sf = SessionHelper.getConnection();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Insurance_Claim.class);
		criteria.add(Restrictions.eq("claim_Id", claim_Id));
		Insurance_Claim req = (Insurance_Claim) criteria.uniqueResult();
		sessionMap.put("req", req);
		return "ClaimRequest.jsp?faces-redirect=true";
	}

	public double getCoverageAmount(String benefits) {
		InsurancePlans insPlan = new InsurancePlans();
		System.out.println("benefits " + benefits);
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(InsurancePlans.class);
		criteria.add(Restrictions.eq("benefits", benefits));
		insPlan = (InsurancePlans) criteria.uniqueResult();
		return insPlan.getCoverageamt();

	}

	public String getDisease(int plan_id) {
		InsurancePlans insPlan = new InsurancePlans();
		System.out.println("plan_id " + plan_id);
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(InsurancePlans.class);
		criteria.add(Restrictions.eq("planid", plan_id));
		insPlan = (InsurancePlans) criteria.uniqueResult();
		return insPlan.getCovered_Disease();

	}

	public Insurance_Details getInsuranceObject(int planid) {
		InsurancePlans insPlan = new InsurancePlans();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(InsurancePlans.class);
		criteria.add(Restrictions.eq("planid", planid));
		insPlan = (InsurancePlans) criteria.uniqueResult();
		String insuranceId = insPlan.getInsuranceid();
		Insurance_Details ins = new Insurance_Details();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Criteria cr = session.createCriteria(Insurance_Details.class);
		cr.add(Restrictions.eq("insuranceId", insuranceId));
		ins = (Insurance_Details) cr.uniqueResult();
		sessionMap.put("ins", ins);

		return ins;
	}

	public String getEmail(String uhid) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Patient_Enrollment.class);
		cr.add(Restrictions.eq("uHID", uhid));
		Patient_Enrollment pt = (Patient_Enrollment) cr.uniqueResult();
		String email = pt.getEmail();
		return email;

	}

	public String addClaimHistory(Insurance_Claim claim) {
		System.out.println("Hello hii bye");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(ClaimHistory.class);
		cr.add(Restrictions.eq("claimId", claim.getClaim_Id()));
		System.out.println("Add claim history:" +claim.getClaim_Id());
		ClaimHistory cl = new ClaimHistory();
		cl=(ClaimHistory) cr.uniqueResult();
		if(cl!=null) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		//ClaimHistory cl = new ClaimHistory();
		double amount;
		amount = (claim.getBill_Amount() + claim.getMis_Amount())* (0.8)
				+cl.getReimbursementAmount();
		double amount2=(claim.getBill_Amount() + claim.getMis_Amount())* (0.2);
		cl.setReimbursementAmount(amount);
		cl.setPatientResponsibility(amount2);
		cl.setFromDate(claim.getAdmit_date());
		cl.setToDate(claim.getDisc_date());
		cl.setStatus(Status.valueOf("ACCEPTED"));
		cl.setProviderId(claim.getProviderid());
		cl.setClaimId(claim.getClaim_Id());
		cl.setSubscription_Id(claim.getSubscription_Id());
		cl.setUhid(claim.getuHID());
		cl.setComments(claim.getComments());
		session.update(cl);
		transaction.commit();
		}else {
			ClaimHistory cl1 = new ClaimHistory();
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			//ClaimHistory cl = new ClaimHistory();
			double amount;
			amount = claim.getBill_Amount() + claim.getMis_Amount();
			double amount2=(claim.getBill_Amount() + claim.getMis_Amount())* (0.2);

			cl.setReimbursementAmount(amount);
			cl.setPatientResponsibility(amount2);
			cl1.setFromDate(claim.getAdmit_date());
			cl1.setToDate(claim.getDisc_date());
			cl1.setStatus(Status.valueOf("ACCEPTED"));
			cl1.setProviderId(claim.getProviderid());
			cl1.setClaimId(claim.getClaim_Id());
			cl.setSubscription_Id(claim.getSubscription_Id());
			cl1.setUhid(claim.getuHID());
			cl1.setComments(claim.getComments());
			session.save(cl1);
			transaction.commit();
		}
		String emailId = getEmail(claim.getuHID());
		String body = "Welcome Mr/Miss  " + "\r\n" + "Your OTP Generated Successfully..." + "\r\n" + "OTP is ";
		MailSend.mailOtp(emailId, "Otp Send Succesfully...", body);
		return "ShowClaimHistory.jsp?faces-redirect=true";
	}
	
	
	public ClaimHistory getClaimHistoryObject(int claimId) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(ClaimHistory.class);
		cr.add(Restrictions.eq("claimId", claimId));
		ClaimHistory claim=(ClaimHistory) cr.uniqueResult();
		return claim;
	}

}
