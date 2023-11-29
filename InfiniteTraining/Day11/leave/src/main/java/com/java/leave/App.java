package com.java.leave;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    static LeaveBAL bal;
    static Scanner sc;
    static {
        bal = new LeaveBAL();
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("O P T I O N S");
            System.out.println("-------------");
            System.out.println("1. Add leave");
            System.out.println("2. Show leave");
            System.out.println("3. search leave Details..");
            System.out.println("4. Update leave details....");
            System.out.println("5. Delete Details..");
            System.out.println("6. Accept or deny..");
            System.out.println("Enter Your Choice  ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                        addLeaveDetailsMain();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    showLeaveMain();
                    break;
                case 3:
                	searchLeaveMain();
                	break;
                case 4:
				try {
					updateLeaveMain();
				} catch (LeaveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                	break;
                case 5:
				try {
					deleteLeaveMain();
				} catch (LeaveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                	break;
                case 6:
                	AcceptorDenyMain();
                	break;
                	
            }
        } while (choice != 7);
    }

    public static void AcceptorDenyMain() {
		// TODO Auto-generated method stub
    	int leaveId;
    	System.out.println("Enter Leave id");
    	leaveId = sc.nextInt();
    	System.out.println("Enter leave status");
    	String leav2;
    	leav2=sc.next();
    	System.out.println("Enter manager comments");
    	String mgc;
    	mgc=sc.next();
    	System.out.println(bal.AcceptorDeny(leaveId, leav2, mgc));
    	
		
	}

	public static void deleteLeaveMain() throws LeaveException{
		
    	int empno;
    	System.out.println("Enter employee number..");
    	empno=sc.nextInt();
    	System.out.println(bal.deleteLeaveBal(empno));
		
	}

	public static void updateLeaveMain() throws LeaveException {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LeaveDetails leave_up = new LeaveDetails();
        System.out.println("Enter Empno...");
        leave_up.setEmpno(sc.nextInt());
        System.out.println("Enter Employee Name ");
        leave_up.setName(sc.next());
        System.out.println("Enter Leave Start Date ..(yyyy-MM-dd)");
        try {
            Date startDate = sdf.parse(sc.next());
            leave_up.setLeaveStartDate(startDate);
        } catch (ParseException e) {
            System.err.println("Enter in the format 'yyyy-MM-dd'.");
            return;
        }
        System.out.println("Enter Leave End Date ..(yyyy-MM-dd)");
        try {
            Date endDate = sdf.parse(sc.next());
            leave_up.setLeaveEndDate(endDate);
        } catch (ParseException e) {
            System.err.println("Enter in the format 'yyyy-MM-dd'.");
            return;
        }
        Date date = new Date();
        leave_up.setLeaveAppliedOn(date);
        leave_up.setNoOfDays(calculateDays(leave_up.getLeaveStartDate(), leave_up.getLeaveEndDate()));
        System.out.println("Enter leave type EL,ML,PL..");
        leave_up.setLeaveType(LeaveType.valueOf(sc.next()));
        leave_up.setLeaveStatus(LeaveStatus.PENDING);

        System.out.println(bal.updateLeaveBal(leave_up)); 
//        
    }
		
		
	

	public  static void searchLeaveMain() {
    	int empno;
		System.out.println("Enter leave Empno Number   ");
		empno = sc.nextInt();
		LeaveDetails leave_on = bal.searchLeaveBal(empno);
		if (leave_on != null) {
	         System.out.println("Leave Details Found:");
	         System.out.println(leave_on);
	    } 
		else {
	        System.out.println("Leave Details not found for Empno: " + empno);
	    }
		
	}

	public static void showLeaveMain() {
        List<LeaveDetails> leave = bal.showLeaveDetailsBal();
        if (leave.isEmpty()) {
            System.out.println("There is no leave applications to show.");
        } else {
            for (LeaveDetails leaveDetails : leave) {
                System.out.println(leaveDetails);
            }
        }
    }

    private static int calculateDays(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        int days = (int) (diff / (1000 * 60 * 60 * 24));
        return days;
    }
    

    public static void addLeaveDetailsMain() throws LeaveException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LeaveDetails leave = new LeaveDetails();
        System.out.println("Enter Empno...");
        leave.setEmpno(sc.nextInt());
        System.out.println("Enter Employee Name ");
        leave.setName(sc.next());
        System.out.println("Enter Leave Start Date ..(yyyy-MM-dd)");
        try {
            Date startDate = sdf.parse(sc.next());
            leave.setLeaveStartDate(startDate);
        } catch (ParseException e) {
            System.err.println("Enter in the format 'yyyy-MM-dd'.");
            return;
        }
        System.out.println("Enter Leave End Date ..(yyyy-MM-dd)");
        try {
            Date endDate = sdf.parse(sc.next());
            leave.setLeaveEndDate(endDate);
        } catch (ParseException e) {
            System.err.println("Enter in the format 'yyyy-MM-dd'.");
            return;
        }
        Date date = new Date();
        leave.setLeaveAppliedOn(date);
        leave.setNoOfDays(calculateDays(leave.getLeaveStartDate(), leave.getLeaveEndDate()));
        System.out.println("Enter leave type EL,ML,PL..");
        leave.setLeaveType(LeaveType.valueOf(sc.next()));
        leave.setLeaveStatus(LeaveStatus.PENDING);

        System.out.println(bal.addLeaveDetailsBal(leave)); 
//        
    }
}