package com.hexaware.onlinegrocerydelivery.dto;

public class CustomerDTO {

	private int customerId;
	private String customerName;
	private String email;
	private String phoneNumber;
	private String deliveryAddress;
	
	
	public CustomerDTO() {
		super();
	}


	public CustomerDTO(int customerId, String customerName, String email, String phoneNumber, String deliveryAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.deliveryAddress = deliveryAddress;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getDeliveryAddress() {
		return deliveryAddress;
	}


	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}


	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", deliveryAddress=" + deliveryAddress + "]";
	}


	
	
}
