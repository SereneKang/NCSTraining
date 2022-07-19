package com.ncs.security.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.security.dto.UserRequestDTO;
import com.ncs.security.exception.AgeException;
import com.ncs.security.exception.UserDuplicatedException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ncs.security.dto.JWTResponseDTO;
import com.ncs.security.jwtutil.JWTUtil;
import com.ncs.security.model.MySecuredUsers;
import com.ncs.security.service.PublicService;
import com.ncs.security.service.PublicServiceImpl;

@RestController
@RequestMapping("/public")
@Validated
public class PublicController {
	
	@Autowired
	PublicService userService;
	
	@Autowired
	PublicServiceImpl userServiceImpl;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	//--------------------------------------------- Register --------------------------------------------------------------------------------------------------------------
	@PostMapping("/register")
	public ResponseEntity<MySecuredUsers> doRegister(@RequestBody @Valid MySecuredUsers user)throws AgeException,InvalidFormatException, UserDuplicatedException{
		MySecuredUsers savedUser=userService.registerUser(user);
		return new ResponseEntity<MySecuredUsers>(savedUser,HttpStatus.OK);
	}
	
	
	//--------------------------------------------- Login --------------------------------------------------------------------------------------------------------------
	@PostMapping("/login")
	public ResponseEntity<JWTResponseDTO> doLogin(@RequestBody UserRequestDTO userEntry)throws Exception
	{
		System.out.println("----->> inside public/login "+userEntry);
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntry.getUsername(), userEntry.getPassword()));
			System.out.println();
			
		} catch (Exception e) {
			throw new Exception("Bad credentials ");
		}

		UserDetails userDetails =  userServiceImpl.loadUserByUsername(userEntry.getUsername());
		
		String token = jwtUtil.generateToken(userDetails);
		
		boolean isValid = token!=null?true:false;
		
		JWTResponseDTO jwtResponseDTO = new JWTResponseDTO(token, userEntry.getUsername(), isValid);
		
		return new ResponseEntity<JWTResponseDTO>(jwtResponseDTO, HttpStatus.OK);
	}
	


}
