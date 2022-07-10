package com.tbs01.pojo;

public class Bus {
	
	private int id;
	private String bus_number;
	private String source;
	private String destination;
	private int distance;
	private double fare;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBus_number() {
		return bus_number;
	}
	public void setBus_number(String bus_number) {
		this.bus_number = bus_number;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	
	public String toString() {
		return "Bus [id=" + id + ", bus_number=" + bus_number + ", source=" + source + ", destination=" + destination
				+ ", distance=" + distance + ", fare=" + fare + "]";
	}
	
	
	

}
