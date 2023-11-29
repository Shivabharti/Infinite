package com.java.ims;



public class Ins_Plans {

	private int Plan_ID;
	private String Insurance_id;
	private double PremiumAmount;
	private double CoverageAmount;
	private String PayMode;
	private double InitialAmount;
	public int getPlan_ID() {
		return Plan_ID;
	}
	public String getPayMode() {
		return PayMode;
	}
	public void setPayMode(String payMode) {
		PayMode = payMode;
	}
	public double getInitialAmount() {
		return InitialAmount;
	}
	public void setInitialAmount(double initialAmount) {
		InitialAmount = initialAmount;
	}
	public void setPlan_ID(int plan_ID) {
		Plan_ID = plan_ID;
	}
	public String getInsurance_id() {
		return Insurance_id;
	}
	public void setInsurance_id(String insurance_id) {
		Insurance_id = insurance_id;
	}
	public double getPremiumAmount() {
		return PremiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		PremiumAmount = premiumAmount;
	}
	public double getCoverageAmount() {
		return CoverageAmount;
	}
	public void setCoverageAmount(double coverageAmount) {
		CoverageAmount = coverageAmount;
	}
	@Override
	public String toString() {
		return "Ins_Plans [Plan_ID=" + Plan_ID + ", "
				+ (Insurance_id != null ? "Insurance_id=" + Insurance_id + ", " : "") + "PremiumAmount=" + PremiumAmount
				+ ", CoverageAmount=" + CoverageAmount + "]";
	}
	public Ins_Plans(int plan_ID, String insurance_id, double premiumAmount, double coverageAmount) {
		super();
		Plan_ID = plan_ID;
		Insurance_id = insurance_id;
		PremiumAmount = premiumAmount;
		CoverageAmount = coverageAmount;
	}
	public Ins_Plans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
