package com.java.leave;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface LeaveDAO {
	String addLeaveDetailsDao(LeaveDetails leave);
	List<LeaveDetails>showLeaveDetailsDao();
	String updateleaveDao(LeaveDetails leave_up);
	LeaveDetails searchLeaveDao(int empno);
	String deleteLeave(int empno);
	String ApproveorDeny(int leaveId,String levs,String mgc);
	
}