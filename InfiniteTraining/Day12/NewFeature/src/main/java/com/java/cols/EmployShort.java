package com.java.cols;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployShort {

	public static void main(String[] args) {
		List<Employ> employList= new ArrayList<Employ>();
		employList.add(new Employ(1,"Shiva",90000));
		employList.add(new Employ(2,"Shila",90087));
		employList.add(new Employ(3,"Shivam",764730));
		employList.add(new Employ(4,"Shivaliya",8000));
		employList.add(new Employ(5,"Shivangi",900000));
		
		System.out.println("Short By name-wise");
		Collections.sort(employList, (e1,e2)->{
			return e1.getName().compareTo(e2.getName());
		});
		employList.forEach(System.out::println);
		Collections.sort(employList,(e1,e2)->{
			return (int)(e1.getBasic()-e2.getBasic());
		});
		
		System.out.println("Sort by basic");
		employList.forEach(System.out::println);
	
	}
	
}
