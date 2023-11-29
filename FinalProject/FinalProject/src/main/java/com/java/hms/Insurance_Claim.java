package com.java.hms;

import java.util.Date;

public class Insurance_Claim {

	private int claim_Id;
	private String providerid;
	private int subscription_Id;
	private String uHID;
	private Date admit_date;
	private Date disc_date;
	private int bill_Amount;
	private int mis_Amount;
	private String disease;
	private String comments;
	private String firstName;
	private Date dob;
	private String type;

	public int getSubscription_Id() {
		return subscription_Id;
	}

	public void setSubscription_Id(int subscription_Id) {
		this.subscription_Id = subscription_Id;
	}

	public int getClaim_Id() {
		return claim_Id;
	}

	public void setClaim_Id(int claim_Id) {
		this.claim_Id = claim_Id;
	}

	public String getProviderid() {
		return providerid;
	}

	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}

	public String getuHID() {
		return uHID;
	}

	public void setuHID(String uHID) {
		this.uHID = uHID;
	}

	public Date getAdmit_date() {
		return admit_date;
	}

	public void setAdmit_date(Date admit_date) {
		this.admit_date = admit_date;
	}

	public Date getDisc_date() {
		return disc_date;
	}

	public void setDisc_date(Date disc_date) {
		this.disc_date = disc_date;
	}

	public int getBill_Amount() {
		return bill_Amount;
	}

	public void setBill_Amount(int bill_Amount) {
		this.bill_Amount = bill_Amount;
	}

	public int getMis_Amount() {
		return mis_Amount;
	}

	public void setMis_Amount(int mis_Amount) {
		this.mis_Amount = mis_Amount;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Insurance_Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

}
