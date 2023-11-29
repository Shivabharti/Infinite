package com.java.junit;

import static org.junit.Assert.*; 

import org.junit.Test;

public class EmployTest {

	@Test
	public void testToString() {
		Employ emp= new Employ(1,"Satya", Gender.MALE, "JAVA", "Manager", 90000);
		String result="Employ [empno=1, name=Satya, gender=MALE, dept=JAVA, desig=Manager, basic=90000.0]";
		assertEquals(result, emp.toString());
	}
	
	
	@Test
	public void testGettersAndSetters() {
		Employ employ= new Employ();
		employ.setEmpno(1);
		employ.setName("Satya");
		employ.setGender(Gender.MALE);
		employ.setDept("JAVA");
		employ.setDesig("Manager");
		employ.setBasic(90000);
		
		assertEquals(1,employ.getEmpno());
		assertEquals("Satya", employ.getName());
		assertEquals(Gender.MALE, employ.getGender());
		assertEquals("JAVA", employ.getDept());
		assertEquals("Manager", employ.getDesig());
		assertEquals(90000, employ.getBasic(),0);
	}

	@Test
	public void testConstructor() {
		Employ employ= new Employ();
		assertNotNull(employ);
		Employ emp= new Employ(1,"Satya", Gender.MALE, "JAVA", "Manager", 90000);
		
		assertEquals(1, emp.getEmpno());
		assertEquals("Satya", emp.getName());
		assertEquals(Gender.MALE, emp.getGender());
		assertEquals("JAVA", emp.getDept());
		assertEquals("Manager", emp.getDesig());
		assertEquals(90000, emp.getBasic(),0);//since decimal value is 0
		
	}

}
