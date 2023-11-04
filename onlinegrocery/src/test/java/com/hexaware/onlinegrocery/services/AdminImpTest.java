package com.hexaware.onlinegrocery.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.hexaware.onlinegrocery.entity.Admin;

class AdminImpTest {
	AdminImp b=new AdminImp();
	@Test
	void testCreateAdmin() {
		Admin obj=new Admin();
		assertEquals(1,b.createAdmin(obj));
	}
	@Test
	void testGetAllAdmin() {
		List<Admin> actual=b.getAllAdmin();
		List<Admin> expected=new ArrayList<Admin>();
		expected.add(new Admin(14,"himakar","HI@43"));
		assertEquals(expected, actual);
		
	}

		
}

	

