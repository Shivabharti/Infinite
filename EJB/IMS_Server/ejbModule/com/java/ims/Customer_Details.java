package com.java.ims;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer_Details implements Serializable {

	@Id
	private String Cust_ID;
	private String FirstName;
	private String LastName;
	private String Gender;
	private Date DateOfBirth;
	private String UserName;
	private String PassCode;
	private String Status;
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassCode() {
		return PassCode;
	}
	public void setPassCode(String passCode) {
		PassCode = passCode;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Customer_Details [" + (Cust_ID != null ? "Cust_ID=" + Cust_ID + ", " : "")
				+ (FirstName != null ? "FirstName=" + FirstName + ", " : "")
				+ (LastName != null ? "LastName=" + LastName + ", " : "")
				+ (Gender != null ? "Gender=" + Gender + ", " : "")
				+ (DateOfBirth != null ? "DateOfBirth=" + DateOfBirth + ", " : "")
				+ (UserName != null ? "UserName=" + UserName + ", " : "")
				+ (PassCode != null ? "PassCode=" + PassCode + ", " : "") + (Status != null ? "Status=" + Status : "")
				+ "]";
	}
	public Customer_Details(String cust_ID, String firstName, String lastName, String gender, Date dateOfBirth,
			String userName, String passCode, String status) {
		super();
		Cust_ID = cust_ID;
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		DateOfBirth = dateOfBirth;
		UserName = userName;
		PassCode = passCode;
		Status = status;
	}
	public Customer_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
