package com.java.junit;

import static org.junit.Assert.*; 

import org.junit.Before;

import org.junit.Test;

import java.util.Date;

 

public class LeaveDetailsTest{

 

    @Test

    public void testLeaveDetailsConstructor() {

        int leaveId = 1;

        int empId = 1002;

        String empName = "Shivangi";

        Date leaveStartDate = new Date();

        Date leaveEndDate = new Date();

        LeaveStatus leaveStatus = LeaveStatus.PENDING;

        LeaveType leaveType = LeaveType.PL;

        String leaveReason = "Vacation";

        String managerComments = "Pending approval";

        Date appliedOn = new Date();

 

        LeaveDetails leaveDetails = new LeaveDetails(leaveId,empId,empName, leaveStartDate, leaveEndDate, leaveStatus, leaveType, leaveReason,  managerComments,appliedOn );

 

        // Verify that the object was constructed correctly

        assertEquals(leaveId, leaveDetails.getLeaveId());

        assertEquals(empId, leaveDetails.getEmpId());

        assertEquals(empName, leaveDetails.getEmpName());

        assertEquals(leaveStartDate, leaveDetails.getLeaveStartDate());

        assertEquals(leaveEndDate, leaveDetails.getLeaveEndDate());

        assertEquals(leaveStatus, leaveDetails.getLeaveStatus());

        assertEquals(leaveType, leaveDetails.getLeaveType());

        assertEquals(leaveReason, leaveDetails.getLeaveReason());

        assertEquals(managerComments, leaveDetails.getManagerComments());

        assertEquals(appliedOn, leaveDetails.getAppliedOn());

    }

 

    @Test

    public void testLeaveDetailsToString() {

        int leaveId = 1;

        int empId = 123;

        String empName = "John Doe";

        Date leaveStartDate = new Date();

        Date leaveEndDate = new Date();

        LeaveStatus leaveStatus = LeaveStatus.PENDING;

        LeaveType leaveType = LeaveType.PL;

        String leaveReason = "Vacation";

        String managerComments = "Pending approval";

        Date appliedOn = new Date();

 
        LeaveDetails leaveDetails = new LeaveDetails(leaveId,empId,empName, leaveStartDate, leaveEndDate, leaveStatus, leaveType, leaveReason,  managerComments,appliedOn );

        String expectedToString = "LeaveDetails [leaveId=" + leaveId + ", empId=" + empId + ", empName=" + empName

            + ", leaveStartDate=" + leaveStartDate + ", leaveEndDate=" + leaveEndDate + ", leaveStatus="

            + leaveStatus + ", leaveType=" + leaveType + ", leaveReason=" + leaveReason + ", managerComments="

            + managerComments + ", appliedOn=" + appliedOn + "]";
        	
        assertEquals(expectedToString, leaveDetails.toString());

    }

 

    @Test

    public void testLeaveDetailsGettersAndSetters() {

        LeaveDetails leaveDetails = new LeaveDetails();

 

        // Set values using setters

        leaveDetails.setLeaveId(1);

        leaveDetails.setEmpId(123);

        leaveDetails.setEmpName("John Doe");

        // Set other properties using setters

 

        // Verify values using getters

        assertEquals(1, leaveDetails.getLeaveId());

        assertEquals(123, leaveDetails.getEmpId());

        assertEquals("John Doe", leaveDetails.getEmpName());

        // Verify other properties using getters

    }

    @Test

    public void testSetAppliedOn() {

        LeaveDetails leaveDetails = new LeaveDetails();

        Date appliedOn = new Date();

 

        leaveDetails.setAppliedOn(appliedOn);

 

        assertEquals(appliedOn, leaveDetails.getAppliedOn());

    }

 

    @Test

    public void testSetManagerComments() {

        LeaveDetails leaveDetails = new LeaveDetails();

        String managerComments = "Approved";

 

        leaveDetails.setManagerComments(managerComments);

 

        assertEquals(managerComments, leaveDetails.getManagerComments());

    }

 

    @Test

    public void testSetLeaveReason() {

        LeaveDetails leaveDetails = new LeaveDetails();

        String leaveReason = "Medical Leave";

 

        leaveDetails.setLeaveReason(leaveReason);

 

        assertEquals(leaveReason, leaveDetails.getLeaveReason());

    }

 

    @Test

    public void testSetLeaveType() {

        LeaveDetails leaveDetails = new LeaveDetails();

        LeaveType leaveType = LeaveType.EL;

 

        leaveDetails.setLeaveType(leaveType);

 

        assertEquals(leaveType, leaveDetails.getLeaveType());

    }

 

    @Test

    public void testSetLeaveStatus() {

        LeaveDetails leaveDetails = new LeaveDetails();

        LeaveStatus leaveStatus = LeaveStatus.ACCEPTED;

 

        leaveDetails.setLeaveStatus(leaveStatus);

 

        assertEquals(leaveStatus, leaveDetails.getLeaveStatus());

    }

 

    @Test

    public void testSetLeaveEndDate() {

        LeaveDetails leaveDetails = new LeaveDetails();

        Date leaveEndDate = new Date();

 

        leaveDetails.setLeaveEndDate(leaveEndDate);

 

        assertEquals(leaveEndDate, leaveDetails.getLeaveEndDate());

    }

 

    @Test

    public void testSetLeaveStartDate() {

        LeaveDetails leaveDetails = new LeaveDetails();

        Date leaveStartDate = new Date();

 

        leaveDetails.setLeaveStartDate(leaveStartDate);

 

        assertEquals(leaveStartDate, leaveDetails.getLeaveStartDate());

    }

 

}

 
