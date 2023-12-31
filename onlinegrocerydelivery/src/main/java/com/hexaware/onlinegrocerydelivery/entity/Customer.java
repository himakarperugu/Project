package com.hexaware.onlinegrocerydelivery.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;




/*Author:Himakar
 * Updated:09-11-2023
 * Description: This is a Customer Entity Class
 */


@Entity

public class Customer {
	

	@SequenceGenerator(name="customer_seq",initialValue=1000,allocationSize=1)
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_seq")
	@Id
	private int customerId;
	private String customerName;
	private String email;
	private String phoneNumber;
	private String deliveryAddress;
	private String password;
	private final static String role="CUSTOMER";
	
	
	

	


	public Customer() {
		super();
	}



	public Customer(int customerId, String customerName, String email, String phoneNumber, String deliveryAddress,
			String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.deliveryAddress = deliveryAddress;
		this.password = password;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	

}
