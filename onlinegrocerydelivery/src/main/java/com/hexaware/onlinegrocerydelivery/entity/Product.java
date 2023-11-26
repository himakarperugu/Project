package com.hexaware.onlinegrocerydelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;



/*Author:Himakar
 * Updated:09-11-2023
 *  Description: This is a Product Entity Class
 */

@Entity
public class Product {

	@SequenceGenerator(name="product_seq",initialValue=300,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="product_seq")
	@Id
	private int productId;
	private String productName;
	private String category;
	private String brand;
	private int price;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

	
	

	public Product() {
		super();
	}

	public Product(int productId, String productName, String category, String brand, int price) {
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
