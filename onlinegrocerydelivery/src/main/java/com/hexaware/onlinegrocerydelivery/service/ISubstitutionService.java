package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import com.hexaware.onlinegrocerydelivery.dto.SubstitutionDTO;
import com.hexaware.onlinegrocerydelivery.entity.Substitution;

public interface ISubstitutionService {
	
	public Substitution addSubstitution(SubstitutionDTO substitutionDTO);
	
	public SubstitutionDTO getById(int substituteProductId);
	
	public List<Substitution> getAllSubstitution();
	
	Substitution updateSubstitution(SubstitutionDTO substitutionDTO);
	
	void deleteById(int substituteProductId);

	

}
