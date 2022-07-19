package com.ncs.security.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.security.exception.PincodeException;
import com.ncs.security.model.MySecuredUsers;
import com.ncs.security.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/users")
	public List<MySecuredUsers> getAllUsers()
	{
		return  adminService.getAllUser();
	}
	
	@GetMapping("/users/{pincode}")
	public List<MySecuredUsers>getUsersByPinCode(@PathVariable long pincode) throws PincodeException,NumberFormatException{
		
		return adminService.getUserByPin(pincode);
	}

}
