package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	
	private IProductService productservice;
	
	
	@Autowired
	public ProductController(IProductService productservice) {
		super();
		this.productservice = productservice;
	}

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDTO productDTO) {
		
		return new ResponseEntity<>(productservice.addProduct(productDTO), HttpStatus.CREATED);
	}

	@GetMapping("/getById/{productId}")
	public ProductDTO getById(@PathVariable int productId)throws ProductNotFoundException {
		ProductDTO productDTO=productservice.getById(productId);
		if (productDTO.getProductId()==0) {
			throw new ProductNotFoundException(HttpStatus.BAD_REQUEST, "Product Not Found for productId:"+productId);
		}
		
		return productDTO;
	}
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {

		return productservice.getAllProduct();
	}

	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody ProductDTO productDTO) {
		
		return productservice.updateProduct(productDTO);
	}

	@DeleteMapping("/deleteById/{productId}")
	public void deleteById(int productId) {
		
		productservice.deleteById(productId);

	}

	@GetMapping("/getByCategory/{category}")
	public List<ProductDTO> getByCategory(@PathVariable String category) {
		
		return productservice.getByCategory(category);
	}

	@GetMapping("/getByBrand/{brand}")
	public List<ProductDTO> getByBrand(@PathVariable String brand) {
		
		return productservice.getByBrand(brand);
	}
	@GetMapping("/getByProductName/{productName}")
	public List<ProductDTO> getByProductName(@PathVariable String productName) {
		
		return productservice.getByProductName(productName);
	}
	
	@ExceptionHandler({ProductNotFoundException.class})
	public ResponseEntity<String> ProductException(ProductNotFoundException productexception)
	{
		return new ResponseEntity<String>(productexception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	
	
}
