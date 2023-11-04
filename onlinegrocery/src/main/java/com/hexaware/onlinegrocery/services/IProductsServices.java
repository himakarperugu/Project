package com.hexaware.onlinegrocery.services;

import java.util.List;

import com.hexaware.onlinegrocery.entity.Products;

public interface IProductsServices {
	 public int createProduct(Products product);
	    public int updateProduct(Products product);
	    public Products getProduct(int product_id);
	    public List<Products> getAllProducts();
	    public int deleteProducts(int product_id);
}
