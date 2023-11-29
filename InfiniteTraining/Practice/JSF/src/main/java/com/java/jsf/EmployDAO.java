package com.java.jsf;

import java.util.ArrayList;
import java.util.List;

public class EmployDAO {
	public List<String> getNames() {
		List<String> names = new ArrayList<String>();
		names.add("Sonal");
		names.add("Akanksha");
		names.add("Kishu");
		names.add("Bulbul");
		names.add("Alka");
		names.add("Varsha");
		names.add("Kali");
		return names;
	}

	public List<Employ> showEmploy() {
		List<Employ> employList = new ArrayList<>();
		employList.add(new Employ(1, "Shivangi", "Java", "Developer", 82342.33));
		employList.add(new Employ(2, "Shila", "J2EE", "Expert", 77362.33));
		employList.add(new Employ(3, "Sweta", "MySQL", "Programmer", 98876.33));
		employList.add(new Employ(4, "Kajal", "Angular", "Tester", 55433.33));
		employList.add(new Employ(5, "Sana", "React", "Manager", 65236.33));
		return employList;

	}
}
