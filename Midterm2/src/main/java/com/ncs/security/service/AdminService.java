package com.ncs.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ncs.security.exception.PincodeException;
import com.ncs.security.model.MySecuredUsers;

@Service
public interface AdminService {

	public List<MySecuredUsers> getAllUser();
	public List<MySecuredUsers> getUserByPin(long pin)throws PincodeException;
}
