package com.hexaware.onlinegrocerydelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.onlinegrocerydelivery.dto.SubstitutionDTO;
import com.hexaware.onlinegrocerydelivery.entity.Substitution;
//Author:sakitha

class SubstitutionServiceImpTest {

	@Test
	void testAddSubstitution() {

		Substitution substitution =new Substitution();
		substitution.setSubstitutionId(5001);
		substitution.setOrderId(4001);
		substitution.setProductId(3001);
		substitution.setSubstituteProductId(1001);
		assertEquals(5001, substitution.getSubstitutionId());
		
	}

	@Test
	void testGetById() {
		SubstitutionDTO substitutionDTO = new SubstitutionDTO();
		substitutionDTO.setSubstitutionId(5001);
		substitutionDTO.setOrderId(4001);
		substitutionDTO.setProductId(3001);
		substitutionDTO.setSubstituteProductId(1001);
		assertEquals(5001, substitutionDTO.getSubstitutionId());
	}

	@Test
	void testGetAllSubstitution() {
		SubstitutionDTO substitutionDTO = new SubstitutionDTO();
		substitutionDTO.setSubstitutionId(5001);
		substitutionDTO.setOrderId(4001);
		substitutionDTO.setProductId(3001);
		substitutionDTO.setSubstituteProductId(1001);
	}

	@Test
	void testUpdateSubstitution() {
		Substitution substitution =new Substitution();
		substitution.setSubstitutionId(5001);
		substitution.setOrderId(4001);
		substitution.setProductId(3001);
		substitution.setSubstituteProductId(1001);
		assertEquals(5001, substitution.getSubstitutionId());
	}

	@Test
	void testDeleteById() {
		
	}

}
