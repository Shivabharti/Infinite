package com.java.hms;


public class InsurancePlans {
	
	
	private int planid;
	private String insuranceid;
	private double premiumamt;
	private double coverageamt;
	private String benefits;
	private String covered_Disease;
	
	
	
	public String getCovered_Disease() {
		return covered_Disease;
	}
	public void setCovered_Disease(String covered_Disease) {
		this.covered_Disease = covered_Disease;
	}
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
	}
	public String getInsuranceid() {
		return insuranceid;
	}
	public void setInsuranceid(String insuranceid) {
		this.insuranceid = insuranceid;
	}
	public double getPremiumamt() {
		return premiumamt;
	}
	public void setPremiumamt(double premiumamt) {
		this.premiumamt = premiumamt;
	}
	public double getCoverageamt() {
		return coverageamt;
	}
	public void setCoverageamt(double coverageamt) {
		this.coverageamt = coverageamt;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	@Override
	public String toString() {
		return "InsurancePlans [planid=" + planid + ", insuranceid=" + insuranceid + ", premiumamt=" + premiumamt
				+ ", coverageamt=" + coverageamt + ", benefits=" + benefits + "]";
	}
	public InsurancePlans(int planid, String insuranceid, double premiumamt, double coverageamt, String benefits) {
		super();
		this.planid = planid;
		this.insuranceid = insuranceid;
		this.premiumamt = premiumamt;
		this.coverageamt = coverageamt;
		this.benefits = benefits;
	}
	public InsurancePlans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
