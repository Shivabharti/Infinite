package com.java.lms;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

 

public class LeaveDAOImpl implements LeaveDetailsDAO {

 

	Connection connection;
	PreparedStatement pst;

	public int dateDiff(Date startDate, Date endDate) {
		long ms = endDate.getTime() - startDate.getTime();
		int diff = (int)(ms/(1000 * 60 * 60 * 24));
		diff++;
		return diff;
	}

	@Override
	public String applyLeave(LeaveDetails leaveDetails) throws ClassNotFoundException, SQLException {
//		System.out.println(leaveDetails);
		connection = ConnectionHelper.getConnection();
		int diff = dateDiff(leaveDetails.getLeaveStartDate(), leaveDetails.getLeaveEndDate());
		Date currentDate = new Date(System.currentTimeMillis());
		 if (leaveDetails.getLeaveStartDate().before(currentDate)) {
		        return "Leave start date cannot be yesterday's date";
		    } else  if (leaveDetails.getLeaveEndDate().before(currentDate)) {
		        return "Leave end date cannot be yesterday's date";
		    } else  if (leaveDetails.getLeaveStartDate().after(leaveDetails.getLeaveEndDate())) {
		        return "Leave start date cannot be greater than leave end date";
		    }  else {
		 Employee employee = new EmployeeDAOImpl().searchEmployeeDao(leaveDetails.getEmpId());
		 int leaveAvailable = employee.getLeaveAvail();

	     if (diff > leaveAvailable) {
	            return "No. of days of leave exceeds available leave balance.";
	        }
//		Date currentDate = new Date(0);
		leaveDetails.setNoOfDays(diff);
		String cmd = "Insert into LeaveDetails(EmpId,LeaveStartDate,LeaveEndDate,"
				+ "noOfDays,leaveType,leaveReason) values(?,?,?,?,?,?)";        pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveDetails.getEmpId());
		pst.setDate(2, leaveDetails.getLeaveStartDate());
		pst.setDate(3, leaveDetails.getLeaveEndDate());
		pst.setInt(4, leaveDetails.getNoOfDays());
		pst.setString(5, leaveDetails.getLeaveType().toString());
		pst.setString(6, leaveDetails.getLeaveReason());
		pst.executeUpdate();
		cmd = "Update Employee set LeaveAvail = LeaveAvail - ? Where EmpId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, diff);
		pst.setInt(2, leaveDetails.getEmpId());
		pst.executeUpdate();
		return "Leave Applied...";
		 }
	}

 

	@Override
	public String updateLeaveStatus(int leaveId, int ManagerId, String leaveStatus)
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();

 

	   
	    String cmd = "SELECT ManagerId FROM Employee WHERE EmpId = ?";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, ManagerId);
	    ResultSet manager = pst.executeQuery();

 

	    if (manager.next()) {
	        int managerIdFromDB = manager.getInt("ManagerId");

 

	        if (managerIdFromDB == leaveId) {
	            // Manager is authorized to approve leave
	            cmd = "UPDATE LeaveDetails SET LeaveStatus = ? WHERE LeaveId = ?";
	            pst = connection.prepareStatement(cmd);
	            pst.setString(1, leaveStatus);
	            pst.setInt(2, leaveId);
	            int updatedRows = pst.executeUpdate();

 

	            if (updatedRows > 0) {
	                return "Leave status updated successfully.";
	            } else {
	                return "Failed to update leave status.";
	            }
	        } else {
	            return "Manager is not authorized to approve this leave.";
	        }
	    } else {
	        return "Manager not found.";
	    }


	}

 

	@Override
	public LeaveDetails searchByLeaveId(int leaveId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from LeaveDetails where LeaveId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveId);
		ResultSet rs = pst.executeQuery();
		LeaveDetails leaveDetails = null;
		if (rs.next()) {
			leaveDetails = new LeaveDetails();
			leaveDetails.setLeaveId(leaveId);
			leaveDetails.setEmpId(rs.getInt("EmpId"));
			leaveDetails.setLeaveStartDate(rs.getDate("leaveStartDate"));
			leaveDetails.setLeaveEndDate(rs.getDate("leaveEndDate"));
			leaveDetails.setNoOfDays(rs.getInt("noOfDays"));
			leaveDetails.setLeaveType(LeaveType.valueOf(rs.getString("leaveType")));
			leaveDetails.setLeaveStatus(LeaveStatus.valueOf(rs.getString("leaveStatus")));
			leaveDetails.setLeaveReason(rs.getString("leaveReason"));
		}

 

		return leaveDetails;
	}

 

	@Override
	public String approveOrDeny(int leaveId, int managerId, String status, String managerComments) throws ClassNotFoundException, SQLException {

		LeaveDetails leaveFound = searchByLeaveId(leaveId);

		int empId = leaveFound.getEmpId();

		EmployeeDAO dao = new EmployeeDAOImpl();

		Employee employee = dao.searchEmployeeDao(empId);

		int mgrId = employee.getManagerId();

		int diff = dateDiff(leaveFound.getLeaveStartDate(), leaveFound.getLeaveEndDate());

		LeaveDetails newleave = new LeaveDetails();

		if (managerId==mgrId) {

			if("YES".equals(status)) {

				leaveFound.setLeaveStatus(LeaveStatus.valueOf("ACCEPTED"));

				leaveFound.setNoOfDays(diff);

			}else if("NO".equals(status)) {

				leaveFound.setLeaveStatus(LeaveStatus.valueOf("REJECTED"));

				leaveFound.setNoOfDays(diff);

			}

			System.out.println("NoofLeave is : "+leaveFound.getNoOfDays());

			connection=ConnectionHelper.getConnection();

			String cmd = "Update LeaveDetails set leavestatus=?,managerComments=? where leaveId=?";

			pst = connection.prepareStatement(cmd);

	        pst.setString(1, leaveFound.getLeaveStatus().toString());

	        pst.setString(2, managerComments);

	        

	        pst.setInt(3, leaveId);

	        pst.executeUpdate();

	        

	        if(status.equals("NO")) {

				connection=ConnectionHelper.getConnection();

				cmd = "Update Employee set LeaveAvail = LeaveAvail + ? Where EmpId=?";

				pst = connection.prepareStatement(cmd);

				pst.setInt(1, diff);

				pst.setInt(2, leaveFound.getEmpId());

				pst.executeUpdate();

			}else {

				connection=ConnectionHelper.getConnection();

				cmd = "Update Employee set LeaveAvail = LeaveAvail - ? Where EmpId=?";

				pst = connection.prepareStatement(cmd);

				pst.setInt(1, diff);

				pst.setInt(2, leaveFound.getEmpId());

				pst.executeUpdate();

			}

	        return"Leave Details updated... ";

		} else {

			return "You are un-authoried...";

		}

	}

}