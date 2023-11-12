package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import com.hexaware.onlinegrocerydelivery.dto.ProductDTO;
import com.hexaware.onlinegrocerydelivery.entity.Product;





public interface IProductService {

	
	public Product addProduct(ProductDTO productDTO);

	public ProductDTO getById(int productId);

	public List<Product> getAllProduct();

	Product updateProduct(ProductDTO productDTO);

	void deleteById(int productId);

	public List<ProductDTO> getByCategory(String category);

	public List<ProductDTO> getByBrand(String brand);
	
	public List<ProductDTO> getByProductName(String productName);

	    
}
	

