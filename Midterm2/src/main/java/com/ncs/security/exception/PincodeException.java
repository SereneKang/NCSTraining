package com.ncs.security.exception;

public class PincodeException extends Exception{
	private String errorMsg;
	private long pincode;
	
	
	
	public PincodeException() {
		super();
	}



	public PincodeException(String errorMsg, long pincode) {
		super();
		this.errorMsg = errorMsg;
		this.pincode = pincode;
	}



	public String getErrorMsg() {
		return errorMsg;
	}



	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}



	public long getPincode() {
		return pincode;
	}



	public void setPincode(long pincode) {
		this.pincode = pincode;
	}



	@Override
	public String toString() {
		return  errorMsg +  pincode;
	}



}
