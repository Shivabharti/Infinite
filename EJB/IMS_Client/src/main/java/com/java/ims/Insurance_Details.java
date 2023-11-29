package com.java.ims;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Insurance_Details {

	@Id
	@GeneratedValue
	private String Insurance_id;
	private String Insurance_Name;
	private String Type;
	private int PremiumStart;
	private int PremiumEnd;
	private int MinPeriod;
	private int MaxPeriod;
	private Date LaunchDate;
	private String Status;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    String strDate= formatter.format(LaunchDate);
    
	public String getInsurance_id() {
		return Insurance_id;
	}
	public void setInsurance_id(String insurance_id) {
		Insurance_id = insurance_id;
	}
	public String getInsurance_Name() {
		return Insurance_Name;
	}
	public void setInsurance_Name(String insurance_Name) {
		Insurance_Name = insurance_Name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getPremiumStart() {
		return PremiumStart;
	}
	public void setPremiumStart(int premiumStart) {
		PremiumStart = premiumStart;
	}
	public int getPremiumEnd() {
		return PremiumEnd;
	}
	public void setPremiumEnd(int premiumEnd) {
		PremiumEnd = premiumEnd;
	}
	public int getMinPeriod() {
		return MinPeriod;
	}
	public void setMinPeriod(int minPeriod) {
		MinPeriod = minPeriod;
	}
	public int getMaxPeriod() {
		return MaxPeriod;
	}
	public void setMaxPeriod(int maxPeriod) {
		MaxPeriod = maxPeriod;
	}
	public Date getLaunchDate() {
		return LaunchDate;
	}
	public void setLaunchDate(Date launchDate) {
		LaunchDate = launchDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Insurance_Details [" + (Insurance_id != null ? "Insurance_id=" + Insurance_id + ", " : "")
				+ (Insurance_Name != null ? "Insurance_Name=" + Insurance_Name + ", " : "")
				+ (Type != null ? "Type=" + Type + ", " : "") + "PremiumStart=" + PremiumStart + ", PremiumEnd="
				+ PremiumEnd + ", MinPeriod=" + MinPeriod + ", MaxPeriod=" + MaxPeriod + ", "
				+ (LaunchDate != null ? "LaunchDate=" + LaunchDate + ", " : "")
				+ (Status != null ? "Status=" + Status : "") + "]";
	}
	public Insurance_Details(String insurance_id, String insurance_Name, String type, int premiumStart, int premiumEnd,
			int minPeriod, int maxPeriod, Date launchDate, String status) {
		super();
		Insurance_id = insurance_id;
		Insurance_Name = insurance_Name;
		Type = type;
		PremiumStart = premiumStart;
		PremiumEnd = premiumEnd;
		MinPeriod = minPeriod;
		MaxPeriod = maxPeriod;
		LaunchDate = launchDate;
		Status = status;
	}
	public Insurance_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
