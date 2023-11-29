package com.java.JSFExam;

public class Restaurant {

	private int restId;
	private String name;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restId, String name) {
		super();
		this.restId = restId;
		this.name = name;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
