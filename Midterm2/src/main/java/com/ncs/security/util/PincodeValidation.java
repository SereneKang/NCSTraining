package com.ncs.security.util;

import org.springframework.stereotype.Component;

@Component
public class PincodeValidation {
	
	public boolean pinValidate(long pin) {
		if(Long.toString(pin).length()>8) {
			return false;
		}
		
		return true;
	}

}
