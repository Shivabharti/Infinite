package com.java.cols;

public class LamdaExpr2 {

	public static void main(String[] args) {
		ICalculation obj1=(a,b)->{
			return a+b;
			};
			System.out.println("Sum is "+ obj1.calc(12, 8));
			ICalculation obj2= (a,b)-> {
				return a-b;
			};
			System.out.println("Sub is "+ obj2.calc(100, 50));	
			
			ICalculation obj3= (a,b)-> {
				return a*b;
			};
			System.out.println("Multiplication is "+obj3.calc(100, 800));
		}
	
}
