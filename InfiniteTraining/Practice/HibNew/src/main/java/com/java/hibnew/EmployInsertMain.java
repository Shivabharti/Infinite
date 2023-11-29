package com.java.hibnew;

import java.util.Scanner;

public class EmployInsertMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Employ employ= new Employ();
		System.out.println("Enter employ Number");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter Employ Name");
		employ.setName(sc.next());
		System.out.println("Enter Gender(MALE/FEMALE");
		employ.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Depart");
		employ.setDept(sc.next());
		System.out.println("Enter Desig");
		employ.setDesig(sc.next());
		System.out.println("Enter Basic");
		employ.setBasic(sc.nextDouble());
		EmployDAO dao= new EmployDAOImpl();
		System.out.println(dao.addEmployDao(employ));
	}
}
