package com.hexaware.onlinegrocerydelivery.dto;

import java.util.List;

import com.hexaware.onlinegrocerydelivery.entity.Orders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CustomerDTO {

	@Positive(message ="CustomerID should be a positive number")
	private int customerId;
	@NotBlank(message ="Customer name is required")
	private String customerName;
	@Email(message="Invalid email format")
	private String email;
	@Pattern(regexp="\\d{10}",message="Phone number must be 10 digits")
	private String phoneNumber;
	@NotBlank(message="Delivery address is required")
	private String deliveryAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Orders>order;
	
	
	public List<Orders> getOrder() {
		return order;
	}


	public void setOrder(List<Orders> order) {
		this.order = order;
	}


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
