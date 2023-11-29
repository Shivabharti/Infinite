package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployUpdateMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Employ employ= new Employ();
		System.out.println("Enter Employ Number :");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter Employ Name:");
		employ.setName(sc.next());
		System.out.println("Enter Gender:");
		employ.setGender(Gender.valueOf(sc.next()));
		System.out.println("ENter Department");
		employ.setDept(sc.next());
		System.out.println("ENter Designation");
		employ.setDesig(sc.next());
		System.out.println("Enter Basic");
		employ.setBasic(sc.nextDouble());
		EmployDAO dao= new EmployDAOImpl();
		try {
			System.out.println(dao.updateEmployDao(employ));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
