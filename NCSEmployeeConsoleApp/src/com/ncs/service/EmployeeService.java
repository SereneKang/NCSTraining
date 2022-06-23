package com.ncs.service;

import java.sql.SQLException;
import java.util.List;

import com.ncs.model.Employee;

public interface EmployeeService {

	public boolean saveEmployee(Employee e) throws SQLException;
	public Employee getEmployeeByID(int id);
	public List<Employee> getAllEmploye()throws SQLException;
	public Employee doLinkProjectWithEmployee(int empId,int projetId);
	
	public boolean validateSalary(int salary,String designation);
	
}