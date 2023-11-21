package com.hexaware.onlinegrocerydelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.onlinegrocerydelivery.dto.AdminDTO;
import com.hexaware.onlinegrocerydelivery.entity.Admin;
//Author:Himakar

class AdminServiceImpTest {

	@Test
	void testAddAdmin() {
		Admin admin =new Admin();
		admin.setAdminId(101);
		admin.setUserName("Sakitha");
		admin.setPassword("Sakitha123");
		assertEquals("Sakitha", admin.getUserName());
	}

	

	@Test
	void testGetById() {
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminId(102);
		adminDTO.setUserName("Sakitha");
		adminDTO.setPassword("Sakitha123");
		assertEquals(102, adminDTO.getAdminId());
	}

	@Test
	void testGetAllAdmin() {
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminId(102);
		adminDTO.setUserName("Sakitha");
		adminDTO.setPassword("Sakitha123");
		}

	@Test
	void testUpdateAdmin() {
		Admin admin=new Admin();
		admin.setAdminId(102);
		admin.setUserName("Sakitha");
		admin.setPassword("Sakitha123");
		assertEquals(102, admin.getAdminId());
	}

	@Test
	void testDeleteById() {
		
	}

	/*@Test
	void testGetByUserName() {
		 AdminDTO adminDTO = new AdminDTO();
         adminDTO.setAdminId(102);
         adminDTO.setUserName("Sakitha");
         adminDTO.setPassword("Sakitha");
         adminDTO.setRole("Admin");
         assertEquals(102, adminDTO.getUserName());
	}*/

}
