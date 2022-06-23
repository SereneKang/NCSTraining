package com.ncs.dao;

import java.sql.SQLException;
import java.util.List;

import com.ncs.model.Employee;

public interface EmployeeDAO {
	public boolean saveEmployee(Employee e)throws SQLException;
	public Employee getEmployeeByID(int id);
	public List<Employee> getAllEmploye()throws SQLException;
	public Employee doLinkProjectWithEmployee(int empId,int projetId);
	
}