package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.AdminDTO;
import com.hexaware.onlinegrocerydelivery.entity.Admin;
import com.hexaware.onlinegrocerydelivery.repository.AdminRepository;

import ch.qos.logback.classic.Logger;
@Service
public class AdminServiceImp implements IAdminService {
	
	

	private AdminRepository adminrepository;
	@Autowired
	public AdminServiceImp(AdminRepository adminrepository) {
		super();
		this.adminrepository = adminrepository;
	}
	//Logger logger= LoggerFactory.getLogger(AdminServiceImp.class);
	@Override
	public Admin addAdmin(AdminDTO adminDTO) {
		Admin admin =new Admin();
		
		
		admin.setAdminId(adminDTO.getAdminId());
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(adminDTO.getPassword());
		admin.setRole(adminDTO.getRole());
		//logger.info("addAdmin method is implemented");
		return adminrepository.save(admin);
	}

	@Override
	public AdminDTO getById(int adminId) {
		Admin admin = adminrepository.findById(adminId).orElse(null);
		
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminId(admin.getAdminId());
		adminDTO.setUserName(admin.getUserName());
		adminDTO.setPassword(admin.getPassword());
		admin.setRole(adminDTO.getRole());
		
		

		
		return adminDTO;
	}

	@Override
	public List<Admin> getAllAdmin() {
		
		return adminrepository.findAll();
		
	}

	@Override
	public Admin updateAdmin(AdminDTO adminDTO) {
		Admin admin=new Admin();
		admin.setAdminId(adminDTO.getAdminId());
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(adminDTO.getPassword());
		admin.setRole(adminDTO.getRole());
		
		return adminrepository.save(admin);
	}

	@Override
	public void deleteById(int adminId) {
		Admin admin=adminrepository.findById(adminId).orElse(null);
		adminrepository.deleteById(admin.getAdminId());
	}

}
