package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.SubstitutionDTO;
import com.hexaware.onlinegrocerydelivery.entity.Substitution;
import com.hexaware.onlinegrocerydelivery.repository.SubstitutionRepository;
@Service
public class SubstitutionServiceImp implements ISubstitutionService {
	
	
	Logger logger = LoggerFactory.getLogger(SubstitutionServiceImp.class);

	
	private SubstitutionRepository substitutionrepository;
	
	
	@Autowired
	public SubstitutionServiceImp(SubstitutionRepository substitutionrepository) {
		super();
		this.substitutionrepository = substitutionrepository;
	}

	@Override
	public Substitution addSubstitution(SubstitutionDTO substitutionDTO) {
		
		Substitution substitution =new Substitution();
		
		
		substitution.setSubstitutionId(substitutionDTO.getSubstitutionId());
		substitution.setOrderId(substitutionDTO.getOrderId());
		substitution.setProductId(substitutionDTO.getProductId());
		substitution.setSubstituteProductId(substitutionDTO.getSubstituteProductId());
		
		logger.info("Inserted Substitution Data Into Table " +substitutionDTO);
		
		return substitutionrepository.save(substitution);
	}

	@Override
	public SubstitutionDTO getById(int substituteProductId) {
		
		
		Substitution substitution = substitutionrepository.findById(substituteProductId).orElse(null);
		SubstitutionDTO substitutionDTO = new SubstitutionDTO();
		substitution.setSubstitutionId(substitutionDTO.getSubstitutionId());
		substitution.setOrderId(substitutionDTO.getOrderId());
		substitution.setProductId(substitutionDTO.getProductId());
		substitution.setSubstituteProductId(substitutionDTO.getSubstituteProductId());
		
		logger.info("Fetched Substitution Data Using Substitution ID " + substituteProductId);
		
		return substitutionDTO;
	}

	@Override
	public List<Substitution> getAllSubstitution() {
		
		logger.info(" Fetched All The Substitution Data ");
		
		return substitutionrepository.findAll();
	}

	@Override
	public Substitution updateSubstitution(SubstitutionDTO substitutionDTO) {
		
		Substitution substitution =new Substitution();
		substitution.setSubstitutionId(substitutionDTO.getSubstitutionId());
		substitution.setOrderId(substitutionDTO.getOrderId());
		substitution.setProductId(substitutionDTO.getProductId());
		substitution.setSubstituteProductId(substitutionDTO.getSubstituteProductId());
		
		logger.info("  Updated Substitution Data Into Table " + substitutionDTO);
		
		return substitutionrepository.save(substitution);
	}

	@Override
	public void deleteById(int substituteProductId) {
		Substitution substitution=substitutionrepository.findById(substituteProductId).orElse(null);
		substitutionrepository.deleteById(substitution.getSubstituteProductId());
		logger.info(" Deleting the Substitution Record Using Substitution ID "+substituteProductId);
		

	}

}
