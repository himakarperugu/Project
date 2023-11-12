package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.SubstitutionDTO;
import com.hexaware.onlinegrocerydelivery.entity.Substitution;
import com.hexaware.onlinegrocerydelivery.repository.SubstitutionRepository;
@Service
public class SubstitutionServiceImp implements ISubstitutionService {
	@Autowired
	SubstitutionRepository repo;

	@Override
	public Substitution addSubstitution(SubstitutionDTO substitutionDTO) {
		
		Substitution substitution =new Substitution();
		
		
		substitution.setSubstitutionId(substitutionDTO.getSubstitutionId());
		substitution.setOrderId(substitutionDTO.getOrderId());
		substitution.setProductId(substitutionDTO.getProductId());
		substitution.setSubstituteProductId(substitutionDTO.getSubstituteProductId());
		
		return repo.save(substitution);
	}

	@Override
	public SubstitutionDTO getById(int substituteProductId) {
		
		
		Substitution substitution = repo.findById(substituteProductId).orElse(null);
		SubstitutionDTO substitutionDTO = new SubstitutionDTO();
		substitution.setSubstitutionId(substitutionDTO.getSubstitutionId());
		substitution.setOrderId(substitutionDTO.getOrderId());
		substitution.setProductId(substitutionDTO.getProductId());
		substitution.setSubstituteProductId(substitutionDTO.getSubstituteProductId());
		
		return substitutionDTO;
	}

	@Override
	public List<Substitution> getAllSubstitution() {
		
		return repo.findAll();
	}

	@Override
	public Substitution updateSubstitution(SubstitutionDTO substitutionDTO) {
		
		Substitution substitution =new Substitution();
		substitution.setSubstitutionId(substitutionDTO.getSubstitutionId());
		substitution.setOrderId(substitutionDTO.getOrderId());
		substitution.setProductId(substitutionDTO.getProductId());
		substitution.setSubstituteProductId(substitutionDTO.getSubstituteProductId());
		
		return repo.save(substitution);
	}

	@Override
	public void deleteById(int substituteProductId) {
		Substitution substitution=repo.findById(substituteProductId).orElse(null);
		repo.deleteById(substitution.getSubstituteProductId());

	}

}
