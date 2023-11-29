package com.java.ims;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Customer_Authorization implements Serializable{

	@Id
	private int Auth_ID;
	@JoinColumn(name="Cust_ID")
	private String Cust_ID;
	private int Otp;
	private String Status;
	public int getAuth_ID() {
		return Auth_ID;
	}
	public void setAuth_ID(int auth_ID) {
		Auth_ID = auth_ID;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
	public int getOtp() {
		return Otp;
	}
	public void setOtp(int otp) {
		Otp = otp;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Customer_Authorization [Auth_ID=" + Auth_ID + ", "
				+ (Cust_ID != null ? "Cust_ID=" + Cust_ID + ", " : "") + "Otp=" + Otp + ", "
				+ (Status != null ? "Status=" + Status : "") + "]";
	}
	public Customer_Authorization(int auth_ID, String cust_ID, int otp, String status) {
		super();
		Auth_ID = auth_ID;
		Cust_ID = cust_ID;
		Otp = otp;
		Status = status;
	}
	public Customer_Authorization() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
