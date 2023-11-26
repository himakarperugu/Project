package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.ProductDTO;
import com.hexaware.onlinegrocerydelivery.entity.Product;
import com.hexaware.onlinegrocerydelivery.exception.ProductNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.IProductRepository;
//Author:Himakar

@Service
public class ProductServiceImp implements IProductService {
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);
	
	@Autowired
	private IProductRepository productRepository;
	
	public ProductServiceImp(IProductRepository productrepository) {
		super();
		this.productRepository = productrepository;
	}

	@Override
	public Product addProduct(ProductDTO productDTO) {
		
		Product product =new Product();
		
		
		
		product.setProductName(productDTO.getProductName());
		product.setCategory(productDTO.getCategory());
		product.setBrand(productDTO.getBrand());
		product.setPrice(productDTO.getPrice());
		
		logger.info("Inserted Product Data Into Table " +productDTO);

		return productRepository.save(product);
	}

	@Override
	public ProductDTO getById(int productId) {
		
		Product product = productRepository.findById(productId).orElse(new Product());
		
		if (product.getProductId()==0) {
			throw new ProductNotFoundException(HttpStatus.NOT_FOUND,"Product with Product Id : " +productId+ " Not Found");

		}
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProductName(product.getProductName());
		productDTO.setCategory(product.getCategory());
		productDTO.setBrand(product.getBrand());
		productDTO.setPrice(product.getPrice());
		logger.info("Fetched Product Data Using Product ID " + productId);
		return productDTO;
	}

	@Override
	public List<Product> getAllProduct() {
		
		
		logger.info(" Fetched All The Product Data ");
		
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(ProductDTO productDTO) {
		
		Product product = new Product();
		
		 Product existingProduct = productRepository.findById(productDTO.getProductId()).orElse(null);

	        if (existingProduct != null) {
	       
	            existingProduct.setProductName(productDTO.getProductName());
	            existingProduct.setCategory(productDTO.getCategory());
	            existingProduct.setBrand(productDTO.getBrand());
	            existingProduct.setPrice(productDTO.getPrice());

	            product = productRepository.save(existingProduct);
	        } else {
	          
	            logger.warn("Product with Product ID " + productDTO.getProductId() + " not found.");
	        }

	        logger.info("Updated Product Data Into Table " + productDTO);
	        return product;
	    }


	@Override
	public void deleteById(int productId) {
	    logger.info("Deleting the Product Record Using Product ID " + productId);

	    Product product = productRepository.findById(productId).orElse(null);

	    if (product != null) {
	    	productRepository.deleteById(product.getProductId());
	    } else {
	        logger.warn("Product with Product ID " + productId + " not found. No Deletion Operation is performed.");
	    }
	}


	@Override
	public List<ProductDTO> getByCategory(String category) {
		 List<Product> products = productRepository.getByCategory(category);
		 
		 if (products.isEmpty()) {
		        throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product with  Product Category  Name: " + category + " Not Found");
		    }

		    List<ProductDTO> productDTOs = products.stream()
		            .map(product -> {
		                ProductDTO productDTO = new ProductDTO();
		                productDTO.setProductId(product.getProductId());
		                productDTO.setProductName(product.getProductName());
		                productDTO.setCategory(product.getCategory());
		                productDTO.setBrand(product.getBrand());
		                productDTO.setPrice(product.getPrice());
		                return productDTO;
		            })
		            .collect(Collectors.toList());
		    logger.info("Fetched Product Data Using Product Category " + category);
		    return productDTOs;
		}
	

	@Override
	public List<ProductDTO> getByBrand(String brand) {
		 List<Product> products = productRepository.getByBrand(brand);
		 
		 
		 if (products.isEmpty()) {
		        throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product with  Product Brand  Name: " + brand + " Not Found");
		    }


	 
	        List<ProductDTO> productDTOs = products.stream()
	                .map(product -> {
	                    ProductDTO productDTO = new ProductDTO();
	                    productDTO.setProductId(product.getProductId());
	                    productDTO.setProductName(product.getProductName());
	                    productDTO.setCategory(product.getCategory());
	                    productDTO.setBrand(product.getBrand());
	                    productDTO.setPrice(product.getPrice());
	                    return productDTO;
	                })
	                .collect(Collectors.toList());
	        logger.info("Fetched Product Data Using Product Brand " + brand);
	        return productDTOs;
	}
	public List<ProductDTO> getByProductName(String productName) {
	    List<Product> products = productRepository.getByProductName(productName);
	    
	    
		 if (products.isEmpty()) {
		        throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product with Product Name: " + productName + " Not Found");
		    }

		 
	    
	    logger.info("Fetched Product Data Using Product Name " + productName);
	    
	    return products.stream()
	            .map(product -> new ProductDTO(
	                    product.getProductId(),
	                    product.getProductName(),
	                    product.getCategory(),
	                    product.getBrand(),
	                    product.getPrice()
	                    
	            ))
	            .collect(Collectors.toList());
	}


}
