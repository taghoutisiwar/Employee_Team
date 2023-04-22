package com.application.employee.team.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.application.employee.team.Entity.User;
import com.application.employee.team.Entity.UserRegistrationDto;


public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}