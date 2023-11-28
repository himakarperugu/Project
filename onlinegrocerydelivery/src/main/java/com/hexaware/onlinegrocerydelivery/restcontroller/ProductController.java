package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.hexaware.onlinegrocerydelivery.service.IProductService;

import jakarta.validation.Valid;
//Author:Himakar

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	
	private IProductService productservice;
	
	

	public ProductController(IProductService productservice) {
		super();
		this.productservice = productservice;
	}

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody  ProductDTO productDTO) {
		
		return new ResponseEntity<>(productservice.addProduct(productDTO), HttpStatus.CREATED);
	}

	@GetMapping("/getById/{productId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ProductDTO getById(@PathVariable int productId) {
		ProductDTO productDTO=productservice.getById(productId);
		
		return productDTO;
	}
	@GetMapping("/getAllProduct")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public List<Product> getAllProduct() {

		return productservice.getAllProduct();
	}

	@PutMapping("/updateProduct/{productId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
    public Product updateProductByProductId(@RequestBody ProductDTO productDTO) {
        return productservice.updateProduct(productDTO);
    }

	@DeleteMapping("/deleteById/{productId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public void deleteById(int productId) {
		
		productservice.deleteById(productId);

	}

	@GetMapping("/getByCategory/{category}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public List<ProductDTO> getByCategory(@PathVariable String category) {
		
		return productservice.getByCategory(category);
	}

	@GetMapping("/getByBrand/{brand}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public List<ProductDTO> getByBrand(@PathVariable String brand) {
		
		return productservice.getByBrand(brand);
	}
	@GetMapping("/getByProductName/{productName}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public List<ProductDTO> getByProductName(@PathVariable String productName) {
		
		return productservice.getByProductName(productName);
	}
	
//	@ExceptionHandler({ProductNotFoundException.class})
//	public ResponseEntity<String> ProductException(ProductNotFoundException productexception)
//	{
//		return new ResponseEntity<String>(productexception.getMessage(),HttpStatus.BAD_REQUEST);
//		
//	}
//	
	
	
}