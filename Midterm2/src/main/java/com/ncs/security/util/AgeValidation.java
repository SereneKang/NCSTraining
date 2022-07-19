package com.ncs.security.util;

import org.springframework.stereotype.Component;

@Component
public class AgeValidation {

	public boolean ageValidate(int age) {
		if(age<18) {
			return false;
		}
		return true;
	}
}
