package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.AdminDTO;
import com.hexaware.onlinegrocerydelivery.entity.Admin;
import com.hexaware.onlinegrocerydelivery.exception.AdminNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.AdminRepository;

@Service
public class AdminServiceImp implements IAdminService {
	
	
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);
	@Autowired
	private AdminRepository adminrepository;

	public AdminServiceImp(AdminRepository adminrepository) {
		super();
		this.adminrepository = adminrepository;
	}

	@Override
	public Admin addAdmin(AdminDTO adminDTO) {
		Admin admin =new Admin();
		
		
		
		admin.setAdminId(adminDTO.getAdminId());
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(adminDTO.getPassword());
		admin.setRole(adminDTO.getRole());
		logger.info(" Inserted Admin Data Into Table " + adminDTO);
		
		return adminrepository.save(admin);
	}

	@Override
	public AdminDTO getById(int adminId) {
		Admin admin = adminrepository.findById(adminId).orElse(new Admin());
		
		if (admin.getAdminId()==0) {
			throw new AdminNotFoundException(HttpStatus.NOT_FOUND," Admin with AdminId : " + adminId + " Not Found " );

		}
		
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminId(admin.getAdminId());
		adminDTO.setUserName(admin.getUserName());
		adminDTO.setPassword(admin.getPassword());
		admin.setRole(adminDTO.getRole());
		logger.info(" Fetched Admin Data Using Admin ID ");
		

		
		return adminDTO;
	}

	@Override
	public List<Admin> getAllAdmin() {
		
		logger.info(" Fetched All The Admin Data ");
		
		return adminrepository.findAll();
		
	}

	@Override
	public Admin updateAdmin(AdminDTO adminDTO) {
		Admin admin=new Admin();
		admin.setAdminId(adminDTO.getAdminId());
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(adminDTO.getPassword());
		admin.setRole(adminDTO.getRole());
		logger.info(" Updated Admin Data Into Table " + adminDTO );
		
		return adminrepository.save(admin);
	}

	@Override
	public void deleteById(int adminId) {
	    Admin admin = adminrepository.findById(adminId).orElse(null);

	    if (admin != null) {
	        adminrepository.deleteById(admin.getAdminId());
	        logger.info("Deleting the Admin Record Using Admin ID " + adminId);
	    } else {
	        logger.warn("Admin with Admin ID " + adminId + " not found. No Deletion Operation is performed.");
	    }
	}


}
