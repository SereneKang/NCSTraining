package com.ncs.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ncs.security.model.MyUserDetails;
import com.ncs.security.exception.AgeException;
import com.ncs.security.exception.UserDuplicatedException;
import com.ncs.security.model.MySecuredUsers;
import com.ncs.security.repository.UserRepository;
import com.ncs.security.util.AgeValidation;
import com.ncs.security.util.UserDuplicatedChecking;

@Service
public class PublicServiceImpl implements PublicService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AgeValidation ageValidation;
	
	@Autowired
	UserDuplicatedChecking userDuplicatedChecking;
	
	//-------------------------------------- Login -------------------------------------------------------------------------

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MySecuredUsers user=userRepository.getUsersByUsername(username);
		return new MyUserDetails(user);
	}

	//-------------------------------------- Register -------------------------------------------------------------------------

	@Override
	public MySecuredUsers registerUser(MySecuredUsers user) throws AgeException,UserDuplicatedException{
		MySecuredUsers savedUser=new MySecuredUsers();
		if(user!=null) {
			boolean validateStatus=ageValidation.ageValidate(user.getAge());
			boolean duplicatedChecking=userDuplicatedChecking.registerLoginChecking(user);
			if(validateStatus==true && duplicatedChecking==true) {
				savedUser=userRepository.save(user);
			}else if(validateStatus==false){
				throw new AgeException("Age cannot be less than 18.... Age Entering: ",user.getAge());
			}else if(duplicatedChecking==false) {
				throw new UserDuplicatedException("Duplicated Username... Username entered: ",user.getUsername());
			}
		}else {
			throw new NullPointerException("Employee Info Is Null");
		}
		
		return savedUser;
	}
	


}
