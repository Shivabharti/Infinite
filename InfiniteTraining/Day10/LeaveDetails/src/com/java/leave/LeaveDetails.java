package com.java.leave;

import java.util.Date;

public class LeaveDetails {

	private int leaveId;
	private int empno;
	private String name;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private Date leaveAppliedOn;
	private int noOfDays;
	private LeaveType leaveType;
	private LeaveStatus leaveStatus;
	private String managerComments;
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Date getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public Date getLeaveAppliedOn() {
		return leaveAppliedOn;
	}
	public void setLeaveAppliedOn(Date leaveAppliedOn) {
		this.leaveAppliedOn = leaveAppliedOn;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getManagerComments() {
		return managerComments;
	}
	public void setManagerComments(String managerComments) {
		this.managerComments = managerComments;
	}
	public LeaveDetails(int leaveId, int empno, String name, Date leaveStartDate, Date leaveEndDate,
			Date leaveAppliedOn, int noOfDays, LeaveType leaveType, LeaveStatus leaveStatus, String managerComments) {
		super();
		this.leaveId = leaveId;
		this.empno = empno;
		this.name = name;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.leaveAppliedOn = leaveAppliedOn;
		this.noOfDays = noOfDays;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.managerComments = managerComments;
	}
	public LeaveDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LeaveDetails [leaveId=" + leaveId + ", empno=" + empno + ", name=" + name + ", leaveStartDate="
				+ leaveStartDate + ", leaveEndDate=" + leaveEndDate + ", leaveAppliedOn=" + leaveAppliedOn
				+ ", noOfDays=" + noOfDays + ", leaveType=" + leaveType + ", leaveStatus=" + leaveStatus
				+ ", managerComments=" + managerComments + "]";
	}
	
	
	
	
	
	// *** DaoImpl *** 
	
	// leaveAppliedOn will be today's date
	// leaveStatus by default PENDING 
	// noOfDays to be calculated automatically
	// leaveid autoincrement 
	
	// *** BAL *** 
	
	// LeaveStartDate cannot be yesterday's date
	// LeaveEndDate cannot be yesterday's date
	// LeaveEndDate Greater than or equals to leaveStartDate 
	// noOfDays cannot be more than 10 
	
}
