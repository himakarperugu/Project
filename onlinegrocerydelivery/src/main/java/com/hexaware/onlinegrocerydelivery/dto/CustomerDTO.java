package com.hexaware.onlinegrocerydelivery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;




/*Author: Himakar
 * Updated:09-11-2023
 *  Description: This is a  Customer DTO Class
 */

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
	@NotBlank(message = "Password should not be blank")
    @Size(min=4,message="Password must be at least 4 characters long")
	private String password;
	
	

	public CustomerDTO() {
		super();
	}



	public CustomerDTO(@Positive(message = "CustomerID should be a positive number") int customerId,
			@NotBlank(message = "Customer name is required") String customerName,
			@Email(message = "Invalid email format") String email,
			@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits") String phoneNumber,
			@NotBlank(message = "Delivery address is required") String deliveryAddress,
			@NotBlank(message = "Password should not be blank") @Size(min = 4, message = "Password must be at least 4 characters long") String password) {
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


	
	
}
