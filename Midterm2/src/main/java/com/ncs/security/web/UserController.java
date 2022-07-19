package com.ncs.security.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ncs.security.model.MySecuredUsers;
import com.ncs.security.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	//-------------------------------------------- View Own Profile -----------------------------------------------
	@GetMapping("/viewprofile")
	public MySecuredUsers viewProfile() {
		
		return userService.viewProfile();
	}
	
	//-------------------------------------------- Update Own PinCode -----------------------------------------------
	@PutMapping("/updatepincode/{pincode}")
	public ResponseEntity<MySecuredUsers> updatePinCode(@PathVariable long pincode) {
		
		return new ResponseEntity<MySecuredUsers>(userService.updatePinCode(pincode),HttpStatus.OK);
	}
	
}
