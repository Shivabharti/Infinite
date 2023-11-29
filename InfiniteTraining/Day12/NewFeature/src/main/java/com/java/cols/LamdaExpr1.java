package com.java.cols;

public class LamdaExpr1 {

	public static void main(String[] args) {
		IHello obj1=() -> {
			System.out.println("hi i am Shivangi");
		};
		obj1.show();
		IHello obj2= () -> {
			System.out.println("I am Bulbul");
		};
		obj2.show();
		
		IHello obj3 =() -> {
			System.out.println("I am Shila");
		};
		obj3.show();
	}
}
