package com.ncs.security.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncs.security.model.MySecuredUsers;
import com.ncs.security.repository.UserRepository;

@Component
public class UserDuplicatedChecking {
	@Autowired
	UserRepository userRepository;
	
	public boolean registerLoginChecking(MySecuredUsers user) 
	{
		List<MySecuredUsers> userList=userRepository.findAll();
		String username=user.getUsername();
		for(MySecuredUsers u:userList) {
			if(u.getUsername().equalsIgnoreCase(username)) {
				return false;
			}
		}
		return true;
	}
}
