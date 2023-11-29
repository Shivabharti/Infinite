package com.java.hms;

import java.util.Date;

public class Patient_Enrollment {
	private String uHID;
	private String firstName;
	private String lastName;
    private Date dOB;
    private String gender;
    private String userName;
    private String phone_no;
    private String email;
    private String status;
    private String cause;
    private String address;
    private String medHistory;
	public String getuHID() {
		return uHID;
	}
	public void setuHID(String uHID) {
		this.uHID = uHID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getdOB() {
		return dOB;
	}
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMedHistory() {
		return medHistory;
	}
	public void setMedHistory(String medHistory) {
		this.medHistory = medHistory;
	}
	@Override
	public String toString() {
		return "Patient_Enrollment [uHID=" + uHID + ", firstName=" + firstName + ", lastName=" + lastName + ", dOB="
				+ dOB + ", gender=" + gender + ", userName=" + userName + ", phone_no=" + phone_no + ", email=" + email
				+ ", status=" + status + ", cause=" + cause + ", address=" + address + ", medHistory=" + medHistory
				+ "]";
	}
	public Patient_Enrollment(String uHID, String firstName, String lastName, Date dOB, String gender, String userName,
			String phone_no, String email, String status, String cause, String address, String medHistory) {
		super();
		this.uHID = uHID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dOB = dOB;
		this.gender = gender;
		this.userName = userName;
		this.phone_no = phone_no;
		this.email = email;
		this.status = status;
		this.cause = cause;
		this.address = address;
		this.medHistory = medHistory;
	}
	public Patient_Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
