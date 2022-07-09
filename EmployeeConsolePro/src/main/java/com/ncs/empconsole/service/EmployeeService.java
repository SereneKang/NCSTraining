package com.ncs.empconsole.service;

import java.util.List;
import java.util.NoSuchElementException;


import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Department;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.model.Laptop;

public interface EmployeeService {

	public Employee addEmployee(Employee e)throws OutofRangeSalaryException;
	public Employee getEmployeeDetails(int searchedEmpId)throws IllegalArgumentException,NoSuchElementException;
	public Employee getEmployeeDetails(String searchedEmpName);
	
	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployees(int salaryRange1,int salaryRange2);
	public Employee updateProject(int searchEmpId,int projectId);
	public Employee getProject(int searchEmpId,int projectId);
	public boolean deleteEmpById(int id);
	
	public Employee updateDepartment(int searchEmpId,Department department);
	
}