package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.onlinegrocerydelivery.dto.SubstitutionDTO;
import com.hexaware.onlinegrocerydelivery.entity.Substitution;
import com.hexaware.onlinegrocerydelivery.service.ISubstitutionService;


@RestController
@RequestMapping("/api/substitution")
public class SubstitutionController {
	
	@Autowired
	ISubstitutionService service;
	
	
	@PostMapping("/addSubstitution")
	public Substitution addSubstitution(SubstitutionDTO substitutionDTO) {
		
		return service.addSubstitution(substitutionDTO);
	}

	@GetMapping("/getById/{substitutionId}")
	public SubstitutionDTO getById(int substituteProductId) {
	
		return service.getById(substituteProductId);
	}

	@GetMapping("/getAllSubstitution")
	public List<Substitution> getAllSubstitution() {
	
		return service.getAllSubstitution();
	}

	@PutMapping("/updateSubstitution")
	public Substitution updateSubstitution(SubstitutionDTO substitutionDTO) {
		
		return service.updateSubstitution(substitutionDTO);
	}


	@DeleteMapping("/deleteById/{substituteProductId}")
	public void deleteById(int substituteProductId) {
		
		service.deleteById(substituteProductId);

	}

}



