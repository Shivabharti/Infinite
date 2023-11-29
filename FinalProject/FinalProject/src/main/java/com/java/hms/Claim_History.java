package com.java.hms;

import java.util.Date;

public class Claim_History {

	private int claimHistoryId;
	private int claim_Id;
	private String providerId;
	private int subscription_Id;
	private String uhId;
	private Date fromDate;
	private Date toDate;
	private double reimbursementAmount;
	private double patientResponsibility;
	private Status status;
	private String comments;
	public int getClaimHistoryId() {
		return claimHistoryId;
	}
	public void setClaimHistoryId(int claimHistoryId) {
		this.claimHistoryId = claimHistoryId;
	}
	public int getClaim_Id() {
		return claim_Id;
	}
	public void setClaim_Id(int claim_Id) {
		this.claim_Id = claim_Id;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public int getSubscription_Id() {
		return subscription_Id;
	}
	public void setSubscription_Id(int subscription_Id) {
		this.subscription_Id = subscription_Id;
	}
	public String getUhId() {
		return uhId;
	}
	public void setUhId(String uhId) {
		this.uhId = uhId;
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
	

}