package com.java.cols;

public class Emp {

	private int Empno;
	private String name;
	private double basic;
	public int getEmpno() {
		return Empno;
	}
	public void setEmpno(int empno) {
		Empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	@Override
	public String toString() {
		return "Emp [Empno=" + Empno + ", name=" + name + ", basic=" + basic + "]";
	}
	public Emp(int empno, String name, double basic) {
		super();
		Empno = empno;
		this.name = name;
		this.basic = basic;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

