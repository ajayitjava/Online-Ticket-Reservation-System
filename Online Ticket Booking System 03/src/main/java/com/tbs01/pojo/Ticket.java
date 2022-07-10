package com.tbs01.pojo;

public class Ticket {
	
	private int id;
	private int busid;
	private int userid;
	private String source;
	private String destination;
	private double fare;
	private String bookingdate;
	private double payamount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public double getPayamount() {
		return payamount;
	}
	public void setPayamount(double payamount) {
		this.payamount = payamount;
	}
	
	
	public String toString() {
		return "Ticket [id=" + id + ", busid=" + busid + ", userid=" + userid + ", source=" + source + ", destination="
				+ destination + ", fare=" + fare + ", bookingdate=" + bookingdate + ", payamount=" + payamount + "]";
	}
	
	

}
