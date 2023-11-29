package com.java.hms;

import java.util.Date;

public class ClaimHistory {

	private int claimHistoryId;
	private int claimId;
	private String providerId;
	private int subscription_Id;
	private String uhid;
	private Date fromDate;
	private Date toDate;
	private double reimbursementAmount;
	private double patientResponsibility;
	private Status status;
	private String comments;
	
	public int getSubscription_Id() {
		return subscription_Id;
	}

	public void setSubscription_Id(int subscription_Id) {
		this.subscription_Id = subscription_Id;
	}
	
	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public double getPatientResponsibility() {
		return patientResponsibility;
	}

	public void setPatientResponsibility(double patientResponsibility) {
		this.patientResponsibility = patientResponsibility;
	}

	

	public int getClaimHistoryId() {
		return claimHistoryId;
	}

	public void setClaimHistoryId(int claimHistoryId) {
		this.claimHistoryId = claimHistoryId;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getUhid() {
		return uhid;
	}

	public void setUhid(String uhid) {
		this.uhid = uhid;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}




	public ClaimHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

}