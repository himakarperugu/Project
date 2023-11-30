package com.hexaware.onlinegrocerydelivery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hexaware.onlinegrocerydelivery.filter.JwtAuthFilter;
//Author:Himakar

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	JwtAuthFilter authFilter;

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {   
       
        return new CustomerInfoUserDetailsService();
    }

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	return http.csrf().disable().cors().and()             
                .authorizeHttpRequests()
                .requestMatchers(
                		"/api/v1/Admin/authenticate",
                        "/api/v1/Admin/addAdmin",
                        "/api/v1/customer/addCustomer",
                        "/api/v1/login/adminlogin",
                        "/api/v1/login/customerlogin",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-resources/**")
                .permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers(
                		"/api/v1/login/**",
                		"/api/v1/Admin/**",
                        "/api/v1/customer/**",
                        "/api/v1/order/**",
                        "/api/v1/product/**",
                        "/api/v1/cart/**",
                        "/api/v1/substitution/**")
                .authenticated().and() 
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter,UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){   //normal spring security + JWT
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
    
    
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	
    	return config.getAuthenticationManager();
    	
    }
}