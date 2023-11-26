package com.hexaware.onlinegrocerydelivery.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


/*Author: Himakar
 * Updated:09-11-2023
 *  Description: This is a  Product DTO Class
 */

public class ProductDTO {
	
	
	private int productId;
	@NotBlank(message = "Product name is required")
	private String productName;
	@NotBlank(message = "Category is required")
	private String category;
	@NotBlank(message = "Brand is required")
	private String brand;
	@Positive(message = "Price should be a positive number")
	private int price;
	
	
	
	


	public ProductDTO() {
		super();
	}


	public ProductDTO(int productId, String productName, String category, String brand, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.brand = brand;
		this.price = price;
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


	


	
}
