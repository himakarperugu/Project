package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.onlinegrocerydelivery.dto.AdminDTO;
import com.hexaware.onlinegrocerydelivery.entity.Admin;
import com.hexaware.onlinegrocerydelivery.service.IAdminService;

import jakarta.validation.Valid;
//Author:Himakar
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/Admin")
public class AdminController {
	
	
	private IAdminService adminservice;
	
	
	public AdminController(IAdminService adminservice) {
		super();
		this.adminservice = adminservice;
	}

	@PostMapping("/addAdmin")
	public Admin addAdmin(@Valid @RequestBody AdminDTO adminDTO) {
		
		return adminservice.addAdmin(adminDTO);
	}

	@GetMapping("/getById/{adminId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public AdminDTO getById(@PathVariable int adminId) {
		
		return adminservice.getById(adminId);
	}

	@GetMapping("/getAllAdmin")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public List<Admin> getAllAdmin() {
		return adminservice.getAllAdmin();
	}

	@PutMapping("/updateAdmin/{adminId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public Admin updateAdmin(@RequestBody AdminDTO adminDTO, @PathVariable int adminId) {
	    return adminservice.updateAdmin(adminDTO, adminId);
	}


	@DeleteMapping("/deleteById/{adminId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public void deleteById(@PathVariable int adminId) {
		adminservice.deleteById(adminId);

	}
	@GetMapping("/getByUserName/{userName}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public List<AdminDTO> getByUserName(@PathVariable String userName) {
	
		return adminservice.getByUserName(userName);
	}

}
