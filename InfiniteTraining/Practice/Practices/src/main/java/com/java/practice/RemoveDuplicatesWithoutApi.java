package com.java.practice;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesWithoutApi {

	public static void main(String[] args) {
		List<String> elementsWithDuplicates= new ArrayList<>();
		elementsWithDuplicates.add("Shona");
		elementsWithDuplicates.add("Shivangi");
		elementsWithDuplicates.add("Sana");
		elementsWithDuplicates.add("Sana");
		elementsWithDuplicates.add("Sona");
		
		List<String> elementsWithoutDuplicates= new ArrayList<>();
		for (String string : elementsWithDuplicates) {
			if(!elementsWithoutDuplicates.contains(string)) {
				elementsWithoutDuplicates.add(string);
			}
		}
		System.out.println("Elements with duplicates"+ elementsWithDuplicates);
		System.out.println("Elements without duplicates"+ elementsWithoutDuplicates);

	}
}
