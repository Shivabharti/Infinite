package com.java.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_report")
public class PatinetReport implements Serializable {
	@Id
	@Column(name="Report_Id")
	private int reportId;
	
	@Column(name="Patient_Id")
	private String patientId;
	
	@Column(name="TestCode")
	private String testCode;
	
	@Column(name="TestDescription")
	private String testDescription;
	
	@Column(name="Cost")
	private double cost;
	
	@Column(name="Comments")
	private String comments;
	
	@Column(name="TestName")
	private String testName;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public PatinetReport(int reportId, String patientId, String testCode, String testDescription, double cost,
			String comments, String testName) {
		super();
		this.reportId = reportId;
		this.patientId = patientId;
		this.testCode = testCode;
		this.testDescription = testDescription;
		this.cost = cost;
		this.comments = comments;
		this.testName = testName;
	}

	public PatinetReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PatinetReport [reportId=" + reportId + ", patientId=" + patientId + ", testCode=" + testCode
				+ ", testDescription=" + testDescription + ", cost=" + cost + ", comments=" + comments + ", testName="
				+ testName + "]";
	}

	
	
}
