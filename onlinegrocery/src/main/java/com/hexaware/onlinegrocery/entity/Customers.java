package com.hexaware.onlinegrocery.entity;

import java.util.Objects;

public class Customers {
	private int customer_id;
	private String customer_name;
	private String email;
	private String phone_number;
	private String delivery_address;
	
	

	public Customers() {
		// TODO Auto-generated constructor stub
	}



	public Customers(int customer_id, String customer_name, String email, String phone_number,
			String delivery_address) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.email = email;
		this.phone_number = phone_number;
		this.delivery_address = delivery_address;
	}



	public int getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}



	public String getCustomer_name() {
		return customer_name;
	}



	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone_number() {
		return phone_number;
	}



	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}



	public String getDelivery_address() {
		return delivery_address;
	}



	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}



	@Override
	public String toString() {
		return "Customers [customer_id=" + customer_id + ", customer_name=" + customer_name + ", email=" + email
				+ ", phone_number=" + phone_number + ", delivery_address=" + delivery_address + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(customer_id, customer_name, delivery_address, email, phone_number);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return customer_id == other.customer_id && Objects.equals(customer_name, other.customer_name)
				&& Objects.equals(delivery_address, other.delivery_address) && Objects.equals(email, other.email)
				&& Objects.equals(phone_number, other.phone_number);
	}

}
