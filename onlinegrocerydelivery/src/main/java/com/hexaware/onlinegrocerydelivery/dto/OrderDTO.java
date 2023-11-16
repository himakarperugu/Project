package com.hexaware.onlinegrocerydelivery.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderDTO {
	
	private int orderId;
	@NotNull(message = "Customer ID cannot be null")
	private int customerId;
	@NotNull(message = "Order date cannot be null")
    @Future(message = "Order date must be in the future")
	private LocalDate orderDate;
    @NotBlank(message = "Delivery address should not be blank")
	private String deliveryAddress;
    @NotBlank(message = "Payment method should not be blank")
	private String paymentMethod;
    @Min(value = 0, message = "Total amount must be a positive number")
	private double totalAmount;
	
	
	
	public OrderDTO() {
		super();
	}



	public OrderDTO(int orderId, int customerId, LocalDate orderDate, String deliveryAddress, String paymentMethod,
			double totalAmount) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.deliveryAddress = deliveryAddress;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
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



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate
				+ ", deliveryAddress=" + deliveryAddress + ", paymentMethod=" + paymentMethod + ", totalAmount="
				+ totalAmount + "]";
	}
	
	
	
	

}
