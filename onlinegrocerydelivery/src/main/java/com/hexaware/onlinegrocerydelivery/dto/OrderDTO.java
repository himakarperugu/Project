package com.hexaware.onlinegrocerydelivery.dto;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*Author: Sakitha
 * Updated:09-11-2023
 *  Description: This is a Order DTO Class
 */

public class OrderDTO {
	
	private int orderId;
	private int customerId;
	@NotNull(message = "Order date cannot be null")
	private LocalDate orderDate;
    @NotBlank(message = "Delivery address should not be blank")
	private String deliveryAddress;
    @NotBlank(message = "Payment method should not be blank")
	private String paymentMethod;
   

	public OrderDTO() {
		super();
	}



	public OrderDTO(int orderId,int customerId, LocalDate orderDate, String deliveryAddress, String paymentMethod) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.deliveryAddress = deliveryAddress;
		this.paymentMethod = paymentMethod;
		
	}



	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public LocalDate getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}



	public String getDeliveryAddress() {
		return deliveryAddress;
	}



	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}



	public String getPaymentMethod() {
		return paymentMethod;
	}



	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	

}
