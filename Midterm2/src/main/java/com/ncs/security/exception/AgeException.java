package com.ncs.security.exception;

public class AgeException extends Exception {

	private String errorMsg;
	private int age;
	
	public AgeException() {
		super();
	}

	public AgeException(String errorMsg, int age) {
		super();
		this.errorMsg = errorMsg;
		this.age = age;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return   errorMsg + age ;
	}
	
	
	
}
