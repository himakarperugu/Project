package com.hexaware.onlinegrocerydelivery.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartDTO {
	
	
	
	
	@NotNull(message="Id should not be null")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	@NotNull(message="Id should not be null")
	private int customerId;
	@NotNull(message="Id should not be null")
	private int productId;
	@Positive(message = "Price should be a positive number")
	private long price;
	@Positive(message = "Quantity should be a positive number")
	private int quantity;
    @Min(value = 1, message = "Total amount must be a positive number")
	private long totalAmount;
	public CartDTO() {
		super();
	}
	public CartDTO( int cartId,
		int customerId,
		int productId,
		long price,
		int quantity,
		long totalAmount) {
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
	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", customerId=" + customerId + ", productId=" + productId + ", price="
				+ price + ", quantity=" + quantity + ", totalAmount=" + totalAmount + "]";
	}
    
    
    
    
    
    
    
}
