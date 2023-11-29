package com.java.cols;

import java.util.ArrayList;
import java.util.List;

public class EmployList {

	public static void main(String[] args) {
	List<Employ> employList= new ArrayList<Employ>();
	employList.add(new Employ(1,"Shiva",90000));
	employList.add(new Employ(2,"Shila",90087));
	employList.add(new Employ(3,"Shivam",764730));
	employList.add(new Employ(4,"Shivaliya",8000));
	employList.add(new Employ(5,"Shivangi",900000));
	employList.forEach(x -> {
		System.out.println(x);
	});
	
}
}
