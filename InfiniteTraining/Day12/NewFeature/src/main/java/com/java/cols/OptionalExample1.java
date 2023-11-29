package com.java.cols;

import java.util.Optional;

public class OptionalExample1 {

	public static void main(String[] args) {
		String [] str= new String[10];
		str[0]="SHiva";
		str[1]="Sweta";
		str[2]="Swati";
		str[3]="Shila";
		str[4]="Sona";
		str[5]="Sonali";
		str[6]="Simran";
		
		Optional<String> result= Optional.ofNullable(str[8]);
		if(result.isPresent()) {
			System.out.println(str[8]);
		}else {
			System.out.println("Valur=e is not available in the index");
		}
		
	}
}
