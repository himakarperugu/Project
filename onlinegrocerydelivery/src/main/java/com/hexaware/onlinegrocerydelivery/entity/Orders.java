package com.hexaware.onlinegrocerydelivery.entity;

import java.time.LocalDate;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

/*Author:Sakitha
 * updated:12/11/2023
 *  Description: This is a Orders Entity Class
 * 
 */
@Entity
public class Orders {

	@SequenceGenerator(name="order_seq",initialValue=200,allocationSize=1)
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="order_seq")
	@Id
	private int orderId;
	private int customerId;
	private LocalDate orderDate;
	private String deliveryAddress;
	private String paymentMethod;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;									//orders to customer
	
	
	

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Orders() {
		super();
	}


	public Orders(int orderId, int customerId, LocalDate orderDate, String deliveryAddress, String paymentMethod) {
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
