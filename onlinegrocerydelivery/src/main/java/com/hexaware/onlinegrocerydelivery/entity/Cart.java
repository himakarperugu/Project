package com.hexaware.onlinegrocerydelivery.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Cart {
	

	@SequenceGenerator(name="cart_seq",initialValue=100,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cart_seq")
	@Id
	private int cartId;
	private int customerId;
	private int quantity;
	private long totalAmount;
	
	
	
	

	@OneToOne(cascade = CascadeType.MERGE)
	private Customer customer;
	
	

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Cart() {
		super();
	}
	
	
	
	
	
	
	
	public Cart(int cartId, int customerId,  int quantity, long totalAmount) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		

		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	
	
	
	
	
	
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
	
	
	
	
	
	
	

}
