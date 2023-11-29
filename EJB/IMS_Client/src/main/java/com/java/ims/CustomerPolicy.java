package com.java.ims;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerPolicy {
	private int PolicyId;
	private String Cust_ID;
	private String InsuranceId;
	private double InsuranceAmount;
	private String PayMode;
	private double InitialAmount;
	private Date RegisterDate;
	private int planId;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    String strDate= formatter.format(RegisterDate);
    
    
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getPolicyId() {
		return PolicyId;
	}
	public void setPolicyId(int policyId) {
		PolicyId = policyId;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
	public String getInsuranceId() {
		return InsuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		InsuranceId = insuranceId;
	}
	public double getInsuranceAmount() {
		return InsuranceAmount;
	}
	public void setInsuranceAmount(double insuranceAmount) {
		InsuranceAmount = insuranceAmount;
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
	public Date getRegisterDate() {
		return RegisterDate;
	}
	public void setRegisterDate(Date registerDate) {
		RegisterDate = registerDate;
	}
	@Override
	public String toString() {
		return "CustomerPolicy [PolicyId=" + PolicyId + ", " + (Cust_ID != null ? "Cust_ID=" + Cust_ID + ", " : "")
				+ (InsuranceId != null ? "InsuranceId=" + InsuranceId + ", " : "") + "InsuranceAmount="
				+ InsuranceAmount + ", " + (PayMode != null ? "PayMode=" + PayMode + ", " : "") + "InitialAmount="
				+ InitialAmount + ", " + (RegisterDate != null ? "RegisterDate=" + RegisterDate + ", " : "") + "planId="
				+ planId + "]";
	}
	public CustomerPolicy(int policyId, String cust_ID, String insuranceId, double insuranceAmount, String payMode,
			double initialAmount, Date registerDate) {
		super();
		PolicyId = policyId;
		Cust_ID = cust_ID;
		InsuranceId = insuranceId;
		InsuranceAmount = insuranceAmount;
		PayMode = payMode;
		InitialAmount = initialAmount;
		RegisterDate = registerDate;
	}
	public CustomerPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
