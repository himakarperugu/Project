package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.onlinegrocerydelivery.dto.ProductDTO;
import com.hexaware.onlinegrocerydelivery.entity.Product;
import com.hexaware.onlinegrocerydelivery.exception.ProductNotFoundException;
import com.hexaware.onlinegrocerydelivery.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	IProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody ProductDTO productDTO) {
		
		return service.addProduct(productDTO);
	}

	@GetMapping("/getById/{productId}")
	public ProductDTO getById(@PathVariable int productId) {
		

		return service.getById(productId);
	}
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {

		return service.getAllProduct();
	}

	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody ProductDTO productDTO) {
		
		return service.updateProduct(productDTO);
	}

	@DeleteMapping("/deleteById/{productId}")
	public void deleteById(int productId) {
		
		service.deleteById(productId);

	}

	@GetMapping("/getByCategory/{category}")
	public List<ProductDTO> getByCategory(@PathVariable String category) {
		
		return service.getByCategory(category);
	}

	@GetMapping("/getByBrand/{brand}")
	public List<ProductDTO> getByBrand(@PathVariable String brand) {
		
		return service.getByBrand(brand);
	}
	@GetMapping("/getByProductName/{productName}")
	public List<ProductDTO> getByProductName(@PathVariable String productName) {
		
		return service.getByProductName(productName);
	}

}
