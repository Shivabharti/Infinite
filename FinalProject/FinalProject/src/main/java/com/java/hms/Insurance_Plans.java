package com.java.hms;

public class Insurance_Plans {
	private int plan_Id;
	private String insurance_Id;
	private double premium_Amount;
	private double coverage_Amount;
	private String benefits;
	private String covered_Disease;
	public int getPlan_Id() {
		return plan_Id;
	}
	public void setPlan_Id(int plan_Id) {
		this.plan_Id = plan_Id;
	}
	public String getInsurance_Id() {
		return insurance_Id;
	}
	public void setInsurance_Id(String insurance_Id) {
		this.insurance_Id = insurance_Id;
	}
	public double getPremium_Amount() {
		return premium_Amount;
	}
	public void setPremium_Amount(double premium_Amount) {
		this.premium_Amount = premium_Amount;
	}
	public double getCoverage_Amount() {
		return coverage_Amount;
	}
	public void setCoverage_Amount(double coverage_Amount) {
		this.coverage_Amount = coverage_Amount;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	public String getCovered_Disease() {
		return covered_Disease;
	}
	public void setCovered_Disease(String covered_Disease) {
		this.covered_Disease = covered_Disease;
	}

}
