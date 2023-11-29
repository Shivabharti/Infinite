package com.java.cols;

public class Calculation {
	int add(int a, int b) {
		return a+b;
	}
	int sub(int a, int b) {
		return a-b;
	}
	int mul(int a, int b) {
		return a*b;
	}

	public static void main(String[] args) {
		Calculation obj= new Calculation();
		IMethodRef2 m1= obj::add;
		System.out.println("Sum is "+ m1.calc(12, 13));
		
		IMethodRef2 m2= obj::sub;
		System.out.println("Sum is "+ m1.calc(100, 13));
		
		IMethodRef2 m3= obj::mul;
		System.out.println("Sum is "+ m1.calc(10, 10));
	}
}
