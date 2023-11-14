package com.hexaware.onlinegrocerydelivery.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;




/*Author:Himakar
 * Updated:09-11-2023
 */


@Entity
@Table(name="Customer")
public class Customer {
	
	
	@Id
	private int customerId;
	
	@NotNull
	@Size(min = 1, max = 255)
	private String customerName;
	
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]")
	private String email;
	
	@Pattern(regexp = "\\d{10}")
	private String phoneNumber;
	
	@NotBlank
	private String deliveryAddress;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
	private List<Orders> orders;
	
	

	
	
	
	public Customer() {
		super();
	}


	public Customer(int customerId, String customerName, String email, String phoneNumber, String deliveryAddress) {
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
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", deliveryAddress=" + deliveryAddress + "]";
	}


	

}
