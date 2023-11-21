package com.hexaware.onlinegrocerydelivery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;  // Added missing import

import com.hexaware.onlinegrocerydelivery.entity.Admin;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
import com.hexaware.onlinegrocerydelivery.repository.IAdminRepository;
import com.hexaware.onlinegrocerydelivery.repository.ICustomerRepository;
//Author:Himakar

@Service  
public class CustomerInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private IAdminRepository adminRepository;
    @Autowired
    private ICustomerRepository customerRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   
        Admin admin = adminRepository.findByUserName(username)
                .orElse(null);

        if (admin != null) {
            return new AdminInfoUserDetails(admin);
        }

       
        Customer customer = customerRepository.findByCustomerName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found: " + username));

        return new CustomerInfoUserDetails(customer);
    }
    
}
