package com.java.onetoone;

public class Employee {

	private int employeeId;
	private String name;
	private String email;
	private Address address;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Employee(int employeeId, String name, String email, Address address) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
