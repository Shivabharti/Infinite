package com.java.jdbc;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class EmploySearchMain {

	public static void main(String[] args) {
		int empno;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Employ Number: ");
		empno= sc.nextInt();
		EmployDAO dao= new EmployDAOImpl();
		try {
			Optional<Employ> employ= Optional.ofNullable(dao.searchEmployDao(empno));
			if(employ.isPresent()) {
				System.out.println(employ);
			}else {
				System.out.println("***Records not found***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
