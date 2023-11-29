package com.java.hms;

import java.util.Map; 
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HmsController {

	SessionFactory sf;
	Session session;

	private HmsDAOImpl dao;

	public HmsController() {
		dao = new HmsDAOImpl();
	}

	private Insurance_Details insDetails;
	private Insurance_Claim insClaim;
	private Patient_Enrollment patient;
	private Provider provider;
	private InsurancePlans insPlan;
	private ClaimHistory claimHistory;

	public Insurance_Details getInsDetails() {
		return insDetails;
	}

	public void setInsDetails(Insurance_Details insDetails) {
		this.insDetails = insDetails;
	}

	public InsurancePlans getInsPlan() {
		return insPlan;
	}

	public void setInsPlan(InsurancePlans insPlan) {
		this.insPlan = insPlan;
	}

	public ClaimHistory getClaimHistory() {
		return claimHistory;
	}

	public void setClaimHistory(ClaimHistory claimHistory) {
		this.claimHistory = claimHistory;
	}

	public HmsDAOImpl getDao() {
		return dao;
	}

	public void setDao(HmsDAOImpl dao) {
		this.dao = dao;
	}

	public Insurance_Claim getInsClaim() {
		return insClaim;
	}

	public void setInsClaim(Insurance_Claim insClaim) {
		this.insClaim = insClaim;
	}

	public Patient_Enrollment getPatient() {
		return patient;
	}

	public void setPatient(Patient_Enrollment patient) {
		this.patient = patient;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String addClaimHistoryController() throws NamingException {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Insurance_Claim clm = (Insurance_Claim) sessionMap.get("req");
		System.out.println("Claimed Data is " + clm);
		// System.out.println(addValidation(clm));
		if (addValidation(clm) == true) {

			HmsDAOImpl daoNew = new HmsDAOImpl();
			System.out.println("New dao called :" + daoNew);
			daoNew.addClaimHistory(clm);
		}
//		if (addValidation(clm)) {
//				return dao.addClaimHistory(clm);
//		}
		return "";
	}

	public boolean addValidation(Insurance_Claim insClaim) {

		HmsDAOImpl daoNew = new HmsDAOImpl();
		String[] trickyComment = { "Tricky", "Bad Record", "Misleaded" };
		FacesContext context = FacesContext.getCurrentInstance();

		int planId = insClaim.getSubscription_Id();
		System.out.println("Plan Id is  " + planId);

		Insurance_Details insDetails = daoNew.getInsuranceObject(planId);
		System.out.println(insDetails.getInsuranceId());
		int insClaimId = insClaim.getClaim_Id();
		System.out.println("claim Id " + insClaimId);
		
		if (!(daoNew.getDisease(insClaim.getSubscription_Id()).equals(insClaim.getDisease()))) {
			context.addMessage("form:disease",
					new FacesMessage("Patient disease is not matching with the Insurance plan benifits"));
			return false;
		}
		System.out.println(daoNew.getDisease(insClaim.getSubscription_Id()));

		ClaimHistory claims = daoNew.getClaimHistoryObject(insClaimId);
		if (claims != null) {
			System.out.println("claim history Id " + claims.getClaimId());
			int hisClaimId = claims.getClaimId();

			double claimableAmount = daoNew.getCoverageAmount(insClaim.getDisease()) - claims.getReimbursementAmount();
			System.out.println("claimableAmount " + claimableAmount);

			double bill_mis_Amount = insClaim.getBill_Amount() + insClaim.getMis_Amount();
			System.out.println("bill_mis_Amount " + bill_mis_Amount);

			double needToPay = bill_mis_Amount - claimableAmount;

			if (insClaimId == hisClaimId) {
				

				if (claims.getComments().equals(trickyComment)) {
					context.addMessage("form:comments", new FacesMessage("Tricky Recod Found In Claim History"));
					return false;
				}
				System.out.println("claim id is working");

				if (claimableAmount < bill_mis_Amount) {
					context.addMessage("form:bill_Amount", new FacesMessage("You can claim only " + claimableAmount
							+ " amount, rest " + needToPay + " amount you have to pay including gst"));
					return false;
				}
				System.out.println("amount is working");

			}

			if (!insClaim.getAdmit_date().after(insDetails.getPremiumStart())) {
				context.addMessage("form:admit_date", new FacesMessage("Your premium has not started yet"));
				return false;
			}
			System.out.println("date part is working");

			if (!insClaim.getAdmit_date().before(insDetails.getPremiumEnd())) {
				context.addMessage("form:admit_date", new FacesMessage("Your premium has expired"));
				return false;
			}
		}
		System.out.println("Date 2 is working");

		return true;
	}

}
