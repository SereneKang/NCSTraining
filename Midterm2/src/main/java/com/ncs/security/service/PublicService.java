package com.ncs.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ncs.security.exception.AgeException;
import com.ncs.security.exception.UserDuplicatedException;
import com.ncs.security.model.MySecuredUsers;

@Service
public interface PublicService extends UserDetailsService{

	public MySecuredUsers registerUser(MySecuredUsers user) throws AgeException,UserDuplicatedException;
}
