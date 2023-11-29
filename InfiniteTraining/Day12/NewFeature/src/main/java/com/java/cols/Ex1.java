package com.java.cols;

public class Ex1 {
	
	public static void main(String[] args) {
		int[] a= new int[5];
		try {
			a[6]=5/0;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array size is small");
		}
		catch(ArithmeticException ae)
		{
			System.out.println("A");
//		}catch(NumberFormatException ne) {
//			System.out.println("X");
		}catch(Exception e) {
			System.out.println("C");
		}finally {
			System.out.println("Z");
		}
//		try {
//			return ;
//		}
//		catch(Exception e) {
//			System.out.println("hi");
//		}
//		finally {
//			System.out.println("bye");
//		}
		
//		System.out.println("1");
//		try {
//			
//			int c= 5/0;
//			System.out.println("Hi");
//			
//		}catch(ArithmeticException e) {
//			System.out.println("Driver");
//		}
//		System.out.println("Last print");
		
//		try {
//			int x=5/0;
//		}
//		catch(Exception e) {
//			System.out.println("c");
//		}
//		catch(ArithmeticException ae) {
//			System.out.println("B");
//		}
//		finally {
//			System.out.println("z");
//		}
	}
}
