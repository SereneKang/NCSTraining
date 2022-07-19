package com.ncs.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ncs.security.model.MySecuredUsers;
import com.ncs.security.repository.UserRepository;

import io.jsonwebtoken.Jwts;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	//-------------------------------------------- View Profile -----------------------------------------------
	@Override
	public MySecuredUsers viewProfile() {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		
		return  userRepository.getUsersByUsername(userDetails.getUsername());
	}
	//-------------------------------------------- Update PinCode -----------------------------------------------
	@Override
	public MySecuredUsers updatePinCode(long pin) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		MySecuredUsers user=userRepository.getUsersByUsername(userDetails.getUsername());
		user.setPincode(pin);
		userRepository.save(user);
		return user;
	}

}
