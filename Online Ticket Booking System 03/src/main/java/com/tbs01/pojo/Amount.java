package com.tbs01.pojo;

public class Amount {
	
	private int id;
	private double amount;
	private String amount_type;
	private String amount_date;
	private String description;
	private int user_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAmount_type() {
		return amount_type;
	}
	public void setAmount_type(String amount_type) {
		this.amount_type = amount_type;
	}
	public String getAmount_date() {
		return amount_date;
	}
	public void setAmount_date(String amount_date) {
		this.amount_date = amount_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	public String toString() {
		return "Amount [id=" + id + ", amount=" + amount + ", amount_type=" + amount_type + ", amount_date="
				+ amount_date + ", description=" + description + ", user_id=" + user_id + "]";
	}
	
	

}
