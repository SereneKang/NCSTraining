package com.ncs.empconsole.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Employee implements Comparable<Employee>,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	@NotNull(message = "employee name cannot be null")
	private String name;
	@Email(message = "Enter Valid Email")
	private String email;
	private int bankAccount;
	private String address;
	private String designation;
	@Min(message = "min salart is 500",value = 500)
	private int salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="department")
	private Department department;
	
		
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	@Override
	public int compareTo(Employee o) {
		
		return this.getEmpId() - o.getEmpId();
	}
	
	
	
	

}