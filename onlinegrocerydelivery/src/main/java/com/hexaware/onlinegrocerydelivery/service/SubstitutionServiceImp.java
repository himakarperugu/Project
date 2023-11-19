package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.SubstitutionDTO;
import com.hexaware.onlinegrocerydelivery.entity.Orders;
import com.hexaware.onlinegrocerydelivery.entity.Substitution;
import com.hexaware.onlinegrocerydelivery.exception.ProductNotFoundException;
import com.hexaware.onlinegrocerydelivery.exception.SubstitutionNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.IOrderRepository;
import com.hexaware.onlinegrocerydelivery.repository.ISubstitutionRepository;
@Service
public class SubstitutionServiceImp implements ISubstitutionService {
	
	
	Logger logger = LoggerFactory.getLogger(SubstitutionServiceImp.class);

	@Autowired
	private ISubstitutionRepository substitutionrepository;
	
	
	@Autowired
	private IOrderRepository orderrepository1;
	
	
	
	
	public SubstitutionServiceImp(ISubstitutionRepository substitutionrepository) {
		super();
		this.substitutionrepository = substitutionrepository;
	}
	
	

	public IOrderRepository getOrderrepository1() {
		return orderrepository1;
	}



	public void setOrderrepository1(IOrderRepository orderrepository1) {
		this.orderrepository1 = orderrepository1;
	}



	@Override
	public Substitution addSubstitution(SubstitutionDTO substitutionDTO) {
		
		Substitution substitution =new Substitution();
		
		Orders orders=orderrepository1.findById(substitutionDTO.getOrderId()).orElse(null);
		
		
		substitution.setSubstitutionId(substitutionDTO.getSubstitutionId());
		substitution.setOrderId(substitutionDTO.getOrderId());
		substitution.setProductId(substitutionDTO.getProductId());
		substitution.setSubstituteProductId(substitutionDTO.getSubstituteProductId());
		substitution.setOrders(orders);
		logger.info("Inserted Substitution Data Into Table " +substitutionDTO);
		
		
		return substitutionrepository.save(substitution);
	}

	@Override
	public SubstitutionDTO getById(int substitutionId) {
		
		
		
		
		Substitution substitution = substitutionrepository.findById(substitutionId).orElse( new Substitution());
		
		if (substitution.getSubstitutionId()==0) {
			throw new SubstitutionNotFoundException(HttpStatus.NOT_FOUND,"Substitution with substituteProduct Id : " +substitutionId+ " Not Found");

		}
		SubstitutionDTO substitutionDTO = new SubstitutionDTO();
		substitution.setSubstitutionId(substitutionDTO.getSubstitutionId());
		substitution.setOrderId(substitutionDTO.getOrderId());
		substitution.setProductId(substitutionDTO.getProductId());
		substitution.setSubstituteProductId(substitutionDTO.getSubstituteProductId());
		
		logger.info("Fetched Substitution Data Using Substitution ID " + substitutionId);
		
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
	public void deleteById(int substitutionId) {
	    Substitution substitution = substitutionrepository.findById(substitutionId).orElse(null);

	    if (substitution != null) {
	        substitutionrepository.deleteById(substitution.getSubstitutionId());
	        logger.info("Deleting the Substitution Record Using Substitution ID " + substitutionId);
	    } else {
	        logger.warn("Substitution with Substituition ID " + substitutionId + " not found. No Deletion Operation is performed.");
	    }
	}


}
