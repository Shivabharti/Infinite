package com.java.HMS1;

import jakarta.validation.constraints.Size;

public class Patient_Master {
	private String pid;
	private String name;
	private int age;
	private int weight;
	private Gender gender;
	private String address;
	@Size(min=2, max=240)
	private String phoneno;
	private String disease;
	private String doctId;
	private String status;
	private String email;
	private String password;
	private int otp;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDoctId() {
		return doctId;
	}
	public void setDoctId(String doctId) {
		this.doctId = doctId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "Patient_Master [pid=" + pid + ", name=" + name + ", age=" + age + ", weight=" + weight + ", gender="
				+ gender + ", address=" + address + ", phoneno=" + phoneno + ", disease=" + disease + ", doctId="
				+ doctId + ", status=" + status + ", email=" + email + ", password=" + password + ", otp=" + otp + "]";
	}
	public Patient_Master(String pid, String name, int age, int weight, Gender gender, String address, String phoneno,
			String disease, String doctId, String status, String email, String password, int otp) {
		super();
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
		this.address = address;
		this.phoneno = phoneno;
		this.disease = disease;
		this.doctId = doctId;
		this.status = status;
		this.email = email;
		this.password = password;
		this.otp = otp;
	}
	public Patient_Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
