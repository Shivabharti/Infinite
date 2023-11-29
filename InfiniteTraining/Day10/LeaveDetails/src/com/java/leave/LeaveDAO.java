package com.java.leave;

import java.util.*;

public interface LeaveDAO {

	List<LeaveDetails> showLeaveDao();
	String addLeaveDao(LeaveDetails leave);
	
}
