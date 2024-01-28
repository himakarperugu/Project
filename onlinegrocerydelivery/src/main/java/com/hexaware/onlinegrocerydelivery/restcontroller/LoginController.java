package com.hexaware.onlinegrocerydelivery.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.onlinegrocerydelivery.dto.AuthRequest;
import com.hexaware.onlinegrocerydelivery.service.JwtService;
//Author:Himakar
@CrossOrigin("http://localhost:54682")
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService adminDetailsService; // Inject admin UserDetailsService
    private final UserDetailsService userDetailsService; // Inject regular user UserDetailsService

    public LoginController(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            UserDetailsService adminDetailsService,
            UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.adminDetailsService = adminDetailsService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/adminlogin")
    public String adminLogin(@RequestBody AuthRequest authRequest) {
        authenticate(authRequest.getUsername(), authRequest.getPassword(), adminDetailsService);

        String token = jwtService.generateToken(authRequest.getUsername());
        return  token;
    }

    @PostMapping("/customerlogin")
    public String customerLogin(@RequestBody AuthRequest authRequest) {
        authenticate(authRequest.getUsername(), authRequest.getPassword(), userDetailsService);

        String token = jwtService.generateToken(authRequest.getUsername());
        return  token;
    }

    private void authenticate(String username, String password, UserDetailsService userDetailsService) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        if (!authenticate.isAuthenticated()) {
            throw new UsernameNotFoundException("Invalid Username or Password / Invalid request");
        }
    }
}
