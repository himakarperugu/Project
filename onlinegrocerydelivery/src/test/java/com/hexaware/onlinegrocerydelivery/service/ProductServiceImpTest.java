package com.hexaware.onlinegrocerydelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.onlinegrocerydelivery.dto.ProductDTO;
import com.hexaware.onlinegrocerydelivery.entity.Product;
//Author:Himakar

class ProductServiceImpTest {


	@Test
	void testAddProduct() {
		Product product =new Product();
		product.setProductId(3001);
		product.setProductName("Freedom Oil");
		product.setCategory("Oil");
		product.setBrand("Freedom");
		product.setPrice(2000);
		assertEquals(3001,product.getProductId());
	}

	@Test
	void testGetById() {

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(3001);
		productDTO.setProductName("Freedom Oil");
		productDTO.setCategory("Oil");
		productDTO.setBrand("Freedom");
		productDTO.setPrice(2000);
	
		assertEquals(3001,productDTO.getProductId());
	}
	@Test
	void testGetAllProduct() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(3001);
		productDTO.setProductName("Freedom Oil");
		productDTO.setCategory("Oil");
		productDTO.setBrand("Freedom");
		productDTO.setPrice(2000);
	
		}

	@Test
	void testUpdateProduct() {
		Product product =new Product();
		product.setProductId(3001);
		product.setProductName("Freedom Oil");
		product.setCategory("Oil");
		product.setBrand("Freedom");
		product.setPrice(2000);

		assertEquals(3001,product.getProductId());	
		}
	

	@Test
	void testDeleteById() {
	}

	@Test
	void testGetByCategory() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(3001);
		productDTO.setProductName("Freedom Oil");
		productDTO.setCategory("Oil");
		productDTO.setBrand("Freedom");
		productDTO.setPrice(2000);

		assertEquals("Oil",productDTO.getCategory());
	}

	@Test
	void testGetByBrand() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(3001);
		productDTO.setProductName("Freedom Oil");
		productDTO.setCategory("Oil");
		productDTO.setBrand("Freedom");
		productDTO.setPrice(2000);

		assertEquals("Freedom",productDTO.getBrand());	}

	/*@Test
	void testGetByProductName() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(3001);
		productDTO.setProductName("Freedom Oil");
		productDTO.setCategory("Oil");
		productDTO.setBrand("Freedom");
		productDTO.setPrice(2000);
		productDTO.setQuantity(3);
		assertEquals("Freedom oil",productDTO.getProductName());	}*/
	}


