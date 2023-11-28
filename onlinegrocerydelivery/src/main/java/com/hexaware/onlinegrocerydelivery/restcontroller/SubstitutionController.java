package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.onlinegrocerydelivery.dto.SubstitutionDTO;
import com.hexaware.onlinegrocerydelivery.entity.Substitution;
import com.hexaware.onlinegrocerydelivery.service.ISubstitutionService;

//Author:sakitha

@RestController
@RequestMapping("/api/v1/substitution")
public class SubstitutionController {
	
	
	private ISubstitutionService substitutionservice;
	
	
	public SubstitutionController(ISubstitutionService substitutionservice) {
		super();
		this.substitutionservice = substitutionservice;
	}
	
	@PostMapping("/addSubstitution")
	public Substitution addSubstitution(SubstitutionDTO substitutionDTO) {
		
		return substitutionservice.addSubstitution(substitutionDTO);
	}

	

	@GetMapping("/getById/{substitutionId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public SubstitutionDTO getById(int substitutionId) {
	
		return substitutionservice.getById(substitutionId);
	}

	@GetMapping("/getAllSubstitution")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public List<Substitution> getAllSubstitution() {
	
		return substitutionservice.getAllSubstitution();
	}

	@PutMapping("/updateSubstitution/substitutionId")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public Substitution updateSubstitution(SubstitutionDTO substitutionDTO) {
		
		return substitutionservice.updateSubstitution(substitutionDTO);
	}


	@DeleteMapping("/deleteById/{substituteProductId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public void deleteById(int substitutionId) {
		
		substitutionservice.deleteById(substitutionId);

	}

}



