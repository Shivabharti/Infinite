package com.java.HMS1;

public class Room_Master {

	private String room_no;
	private String room_type;
	private String status;
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Room_Master(String room_no, String room_type, String status) {
		super();
		this.room_no = room_no;
		this.room_type = room_type;
		this.status = status;
	}
	public Room_Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
