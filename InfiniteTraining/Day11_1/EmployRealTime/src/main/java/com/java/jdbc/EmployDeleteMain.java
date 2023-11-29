package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployDeleteMain {

	public static void main(String[] args) {
		int empno;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter employ number:");
		empno= sc.nextInt();
		EmployDAO dao= new EmployDAOImpl();
		try {
			System.out.println(dao.deleteEmployDAO(empno));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
