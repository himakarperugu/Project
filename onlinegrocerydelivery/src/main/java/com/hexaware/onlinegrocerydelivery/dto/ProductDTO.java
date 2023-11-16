package com.hexaware.onlinegrocerydelivery.dto;

import java.util.List;

import com.hexaware.onlinegrocerydelivery.entity.Orders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductDTO {
	
	@Positive(message = "Product ID should be a positive number")
	private int productId;
	@NotBlank(message = "Product name is required")
	private String productName;
	@NotBlank(message = "Category is required")
	private String category;
	@NotBlank(message = "Brand is required")
	private String brand;
	@Positive(message = "Price should be a positive number")
	private int price;
	@Positive(message = "Quantity should be a positive number")
	private int quantity;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
		List<Orders>orders;
	
	
	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	public ProductDTO() {
		super();
	}


	public ProductDTO(int productId, String productName, String category, String brand, int price, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", brand=" + brand + ", price=" + price + ", quantity=" + quantity + "]";
	}


	
}
