package com.java.HMS1;

public class Doctor_Master {

	private String doctor_id;
	private String doctor_name;
	private String Dept;
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public Doctor_Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor_Master(String doctor_id, String doctor_name, String dept) {
		super();
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		Dept = dept;
	}
	
	
}
