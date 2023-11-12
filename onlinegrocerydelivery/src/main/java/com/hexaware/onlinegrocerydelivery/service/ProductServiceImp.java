package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.ProductDTO;
import com.hexaware.onlinegrocerydelivery.entity.Admin;
import com.hexaware.onlinegrocerydelivery.entity.Product;
import com.hexaware.onlinegrocerydelivery.repository.AdminRepository;
import com.hexaware.onlinegrocerydelivery.repository.ProductRepository;
@Service
public class ProductServiceImp implements IProductService {
	
	@Autowired
	ProductRepository repo;
	

	@Override
	public Product addProduct(ProductDTO productDTO) {
		
		Product product =new Product();
		
		
		product.setProductId(productDTO.getProductId());
		product.setProductName(productDTO.getProductName());
		product.setCategory(productDTO.getCategory());
		product.setBrand(productDTO.getBrand());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		
		return repo.save(product);
	}

	@Override
	public ProductDTO getById(int productId) {
		
		Product product = repo.findById(productId).orElse(null);
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProductName(product.getProductName());
		productDTO.setCategory(product.getCategory());
		productDTO.setBrand(product.getBrand());
		productDTO.setPrice(product.getPrice());
		productDTO.setQuantity(product.getQuantity());
		
		return productDTO;
	}

	@Override
	public List<Product> getAllProduct() {
		return repo.findAll();
	}

	@Override
	public Product updateProduct(ProductDTO productDTO) {
		
		Product product = new Product();
		
		product.setProductId(product.getProductId());
		product.setProductName(productDTO.getProductName());
		product.setCategory(productDTO.getCategory());
		product.setBrand(productDTO.getBrand());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		
		return repo.save(product);	
		}

	@Override
	public void deleteById(int productId) {
		
	Product product=repo.findById(productId).orElse(null);
	repo.deleteById(product.getProductId());

	}

	@Override
	public List<ProductDTO> getByCategory(String category) {
		 List<Product> products = repo.getByCategory(category);

		    List<ProductDTO> productDTOs = products.stream()
		            .map(product -> {
		                ProductDTO productDTO = new ProductDTO();
		                productDTO.setProductId(product.getProductId());
		                productDTO.setProductName(product.getProductName());
		                productDTO.setCategory(product.getCategory());
		                productDTO.setBrand(product.getBrand());
		                productDTO.setPrice(product.getPrice());
		                productDTO.setQuantity(product.getQuantity());
		                return productDTO;
		            })
		            .collect(Collectors.toList());

		    return productDTOs;
		}
	

	@Override
	public List<ProductDTO> getByBrand(String brand) {
		 List<Product> products = repo.getByBrand(brand);

	 
	        List<ProductDTO> productDTOs = products.stream()
	                .map(product -> {
	                    ProductDTO productDTO = new ProductDTO();
	                    productDTO.setProductId(product.getProductId());
	                    productDTO.setProductName(product.getProductName());
	                    productDTO.setCategory(product.getCategory());
	                    productDTO.setBrand(product.getBrand());
	                    productDTO.setPrice(product.getPrice());
	                    productDTO.setQuantity(product.getQuantity());
	                    return productDTO;
	                })
	                .collect(Collectors.toList());

	        return productDTOs;
	}
	public List<ProductDTO> getByProductName(String productName) {
	    List<Product> products = repo.getByProductName(productName);

	    return products.stream()
	            .map(product -> new ProductDTO(
	                    product.getProductId(),
	                    product.getProductName(),
	                    product.getCategory(),
	                    product.getBrand(),
	                    product.getPrice(),
	                    product.getQuantity()
	            ))
	            .collect(Collectors.toList());
	}


}
