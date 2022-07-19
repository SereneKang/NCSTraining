package com.ncs.security.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class MySecuredUsers {
	
	@Id
	private int id;
	@NotEmpty(message = "username cannot be null")
	@Length(min = 5, message = "username must have at least 5 characters")
	private String username;
	@NotEmpty(message = "password cannot be null")
	@Length(min = 5, message = "password must have at least 5 characters")
	private String password;
	private int age;
	@Digits(integer = 8,fraction = 0)
	private long pincode;
	private String role;
	
	
	public MySecuredUsers() {
		super();
	}

	




	public MySecuredUsers(int id,
			@NotEmpty(message = "username cannot be null") @Length(min = 5, message = "username must have at least 5 characters") String username,
			@NotEmpty(message = "password cannot be null") @Length(min = 5, message = "password must have at least 5 characters") String password,
			int age, @Digits(integer = 8, fraction = 0) long pincode, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.pincode = pincode;
		this.role = role;
	}






	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public long getPincode() {
		return pincode;
	}



	public void setPincode(long pincode) {
		this.pincode = pincode;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public int hashCode() {
		return Objects.hash(age, id, password, pincode, role, username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySecuredUsers other = (MySecuredUsers) obj;
		return age == other.age && id == other.id && Objects.equals(password, other.password)
				&& pincode == other.pincode && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}



	@Override
	public String toString() {
		return "MySecuredUsers [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", pincode=" + pincode + ", role=" + role + "]";
	}
	
	
	

}
