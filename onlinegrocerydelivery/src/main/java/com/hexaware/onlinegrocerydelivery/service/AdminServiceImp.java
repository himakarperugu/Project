package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.AdminDTO;
import com.hexaware.onlinegrocerydelivery.entity.Admin;
import com.hexaware.onlinegrocerydelivery.exception.AdminNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.IAdminRepository;
//Author:Himakar

@Service
public class AdminServiceImp implements IAdminService {
	
	
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);
	@Autowired
	private IAdminRepository adminrepository;
	private PasswordEncoder passwordEncoder;

	
	public AdminServiceImp(IAdminRepository adminrepository, PasswordEncoder passwordEncoder) {
		super();
		this.adminrepository = adminrepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Admin addAdmin(AdminDTO adminDTO) {
		Admin admin =new Admin();
		
		
		
		
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
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
		adminDTO.setUserName(admin.getUserName());
		adminDTO.setPassword(passwordEncoder.encode(admin.getPassword()));
		logger.info(" Fetched Admin Data Using Admin ID ");
		

		
		return adminDTO;
	}

	@Override
	public List<Admin> getAllAdmin() {
		
		logger.info(" Fetched All The Admin Data ");
		
		return adminrepository.findAll();
		
	}

	@Override
	public Admin updateAdmin(AdminDTO adminDTO, int adminId) {
	    // Retrieve the existing Admin entity
	    Admin existingAdmin = adminrepository.findById(adminId)
	            .orElseThrow(() -> new AdminNotFoundException(HttpStatus.NOT_FOUND,
	                    "Admin with id: " + adminId + " not found"));

	    // Update the Admin entity with values from AdminDTO
	    existingAdmin.setUserName(adminDTO.getUserName());
	    existingAdmin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
	    // You can update other fields as well if needed

	    logger.info("Updated Admin Data Into Table: " + existingAdmin);

	    // Save the updated Admin entity back to the database
	    return adminrepository.save(existingAdmin);
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
	@Override
	public List<AdminDTO> getByUserName(String userName) {
	    List<Admin> admins = adminrepository.getByUserName(userName);

	    if (admins.isEmpty()) {
	        throw new AdminNotFoundException(HttpStatus.NOT_FOUND, "Admin with username: " + userName + " Not Found");
	    }

	    List<AdminDTO> adminDTOs = admins.stream()
	            .map(admin -> {
	                AdminDTO adminDTO = new AdminDTO();
	                adminDTO.setUserName(admin.getUserName());
	                adminDTO.setPassword(passwordEncoder.encode(admin.getPassword()));
	                return adminDTO;
	            })
	            .collect(Collectors.toList());

	    logger.info("Fetched Admin Data Using Username: " + userName);

	    return adminDTOs;
	}


	
	
	}



