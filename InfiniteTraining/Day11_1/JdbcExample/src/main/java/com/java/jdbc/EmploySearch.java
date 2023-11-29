package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmploySearch {

	
	public static void main(String[] args) {
		int empno;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Employ Number: ");
		empno= sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection=
					DriverManager.getConnection("jdbc:mysql://localhost:3306/infinite_august23", "root", "root");
					
					String cmd= "select * from Employ where Empno=?";
					PreparedStatement pst= connection.prepareStatement(cmd);
					pst.setInt(1, empno);
					ResultSet rs= pst.executeQuery();
					
					if(rs.next()) {
						System.out.println("Employ number: "+ rs.getInt("empno"));
						System.out.println("Employ name: "+ rs.getString("name"));
						System.out.println("Gender: "+ rs.getString("gender"));
						System.out.println("Department: "+ rs.getString("dept"));
						System.out.println("Designation: "+ rs.getString("desig"));
						System.out.println("Basic: "+ rs.getDouble("basic"));
					}
					else {
						System.out.println("***Record not found***");
					}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
