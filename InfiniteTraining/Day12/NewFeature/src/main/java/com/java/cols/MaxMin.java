package com.java.cols;

import java.util.ArrayList;
import java.util.List;

public class MaxMin {

	public static void main(String[] args) {
		List<Employ> employList= new ArrayList<Employ>();
		employList.add(new Employ(1,"Shiva",90000));
		employList.add(new Employ(2,"Ankita",90087));
		employList.add(new Employ(3,"Dipu",764730));
		employList.add(new Employ(4,"Akanksha",8000));
		employList.add(new Employ(5,"Ashi",900000));
		
		Employ employMax= employList.stream().max((m1,m2)->
		m1.getBasic() > m2.getBasic() ? 1:-1).get();
		
		System.out.println("Employ with max basic ");
		System.out.println(employMax);
		System.out.println("Employ with min basic ");
		Employ employMin= employList.stream().min((m1,m2)->
		m1.getBasic() > m2.getBasic() ? 1 : -1).get();
		System.out.println(employMin);
	}
}
