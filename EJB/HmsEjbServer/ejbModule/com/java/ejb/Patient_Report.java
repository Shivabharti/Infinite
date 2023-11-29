package com.java.ejb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Patient_Report {

	@Id
	private int Report_Id;
	private String Patient_Id;
	private String TestCode;
	private String TestName;
	private String TestDescription;
	private double Cost;
	private String Comments;

	public int getReport_Id() {
		return Report_Id;
	}

	public void setReport_Id(int report_Id) {
		Report_Id = report_Id;
	}

	public String getPatient_Id() {
		return Patient_Id;
	}

	public void setPatient_Id(String patient_Id) {
		Patient_Id = patient_Id;
	}

	public String getTestCode() {
		return TestCode;
	}

	public void setTestCode(String testCode) {
		TestCode = testCode;
	}

	public String getTestName() {
		return TestName;
	}

	public void setTestName(String testName) {
		TestName = testName;
	}

	public String getTestDescription() {
		return TestDescription;
	}

	public void setTestDescription(String testDescription) {
		TestDescription = testDescription;
	}

	public double getCost() {
		return Cost;
	}

	public void setCost(double cost) {
		Cost = cost;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	@Override
	public String toString() {
		return "Patient_Report [Report_Id=" + Report_Id + ", "
				+ (Patient_Id != null ? "Patient_Id=" + Patient_Id + ", " : "")
				+ (TestCode != null ? "TestCode=" + TestCode + ", " : "")
				+ (TestName != null ? "TestName=" + TestName + ", " : "")
				+ (TestDescription != null ? "TestDescription=" + TestDescription + ", " : "") + "Cost=" + Cost + ", "
				+ (Comments != null ? "Comments=" + Comments : "") + "]";
	}

	public Patient_Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient_Report(int report_Id, String patient_Id, String testCode, String testName, String testDescription,
			double cost, String comments) {
		super();
		Report_Id = report_Id;
		Patient_Id = patient_Id;
		TestCode = testCode;
		TestName = testName;
		TestDescription = testDescription;
		Cost = cost;
		Comments = comments;
	}

}
