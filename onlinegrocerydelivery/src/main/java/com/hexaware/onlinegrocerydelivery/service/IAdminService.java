package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import com.hexaware.onlinegrocerydelivery.dto.AdminDTO;
import com.hexaware.onlinegrocerydelivery.entity.Admin;

public interface IAdminService {

	public Admin addAdmin(AdminDTO adminDTO);
	
	public AdminDTO getById(int adminId);
	
	public List<Admin> getAllAdmin();
	
	Admin updateAdmin(AdminDTO adminDTO);
	
	void deleteById(int adminId);
	
	
	
	
}
