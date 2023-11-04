package com.hexaware.onlinegrocery.entity;

import java.util.Objects;

public class Products {
	
	
	
	private int product_id;
	private String product_name;
	private String category;
	private String brand;
	private double price;
	private int quantity;
	
	
	
	

	public Products() {
		// TODO Auto-generated constructor stub
	}



	public Products(int product_id, String product_name, String category, String brand, float price, int quantity) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
	}



	public int getProduct_id() {
		return product_id;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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



	public double getPrice() {
		return price;
	}



	public void setPrice(float price) {
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
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", category=" + category
				+ ", brand=" + brand + ", price=" + price + ", quantity=" + quantity + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(brand, category, price, product_id, product_name, quantity);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(category, other.category)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& product_id == other.product_id && Objects.equals(product_name, other.product_name)
				&& quantity == other.quantity;
	}



	

}
