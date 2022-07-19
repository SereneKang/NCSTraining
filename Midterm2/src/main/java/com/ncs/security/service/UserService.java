package com.ncs.security.service;


import org.springframework.stereotype.Service;

import com.ncs.security.model.MySecuredUsers;

@Service
public interface UserService {

	public MySecuredUsers viewProfile();
	public MySecuredUsers updatePinCode(long pin) ;
}
