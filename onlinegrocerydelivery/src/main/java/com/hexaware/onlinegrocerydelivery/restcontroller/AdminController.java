package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/api/Admin")
public class AdminController {
	
	
	private IAdminService service;
	
	@Autowired
	public AdminController(IAdminService service) {
		super();
		this.service = service;
	}

	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody AdminDTO adminDTO) {
		
		return service.addAdmin(adminDTO);
	}

	@GetMapping("/getById/{adminId}")
	public AdminDTO getById(@PathVariable int adminId) {
		
		return service.getById(adminId);
	}

	@GetMapping("/getAllAdmin")
	public List<Admin> getAllAdmin() {
		return service.getAllAdmin();
	}

	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody AdminDTO adminDTO) {
		return service.updateAdmin(adminDTO);
	}

	@DeleteMapping("/deleteById/{adminId}")
	public void deleteById(@PathVariable int adminId) {
		service.deleteById(adminId);

	}

}
