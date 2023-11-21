package com.hexaware.onlinegrocerydelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {
	
	
	@Id
	private int cartId;
	private int customerId;
	private int productId;
	private long price;
	private int quantity;
	private long totalAmount;
	public Cart() {
		super();
	}
	public Cart(int cartId, int customerId, int productId, long price, int quantity, long totalAmount) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.productId = productId;
		this.price = price;
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
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
