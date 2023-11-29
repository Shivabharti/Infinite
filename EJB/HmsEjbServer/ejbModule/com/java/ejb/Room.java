package com.java.ejb;

import java.io.Serializable;

public class Room implements Serializable{
	private String roomNo;
	private String roomType;
	private String status;
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Room(String roomNo, String roomType, String status) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.status = status;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
