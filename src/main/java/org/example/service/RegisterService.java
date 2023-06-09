package org.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.example.model.User;
import org.example.dto.UserRegistrationDto;

public interface RegisterService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}

