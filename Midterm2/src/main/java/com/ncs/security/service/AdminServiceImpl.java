package com.ncs.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.security.exception.PincodeException;
import com.ncs.security.model.MySecuredUsers;
import com.ncs.security.repository.UserRepository;
import com.ncs.security.util.PincodeValidation;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PincodeValidation pincodeValidation;
	
	//-----------------------------------Get All Users-------------------------------------------------------------------------
	@Override
	public List<MySecuredUsers> getAllUser() {
		
		return userRepository.findAll();
	}

	//-----------------------------------Get Users By Pin-------------------------------------------------------------------------
	@Override
	public List<MySecuredUsers> getUserByPin(long pin) throws PincodeException {
		
		boolean validatedStatus=pincodeValidation.pinValidate(pin);
		if(validatedStatus) {
			return userRepository.getUsersByPin(pin);
		}else {
			throw new PincodeException("Pin must be less than 8 digits",pin);
		}
		
		
		
	}

}
