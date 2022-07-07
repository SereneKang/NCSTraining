package com.ncs.empconsole.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ncs.empconsole.model.Employee;
/*
@Component
public class EmployeeDB {
	
	public static List<Employee> employeeDB = new ArrayList<>();

	static
	{
		Employee e1 = new Employee(101, "Ramesh", 2000,1101);
		Employee e2 = new Employee(102, "Suresh", 2000,1102);
		Employee e3 = new Employee(103, "Mahesh", 1500,1101);
		Employee e4 = new Employee(104, "Rakesh", 7000,1103);
	
		employeeDB.add(e1);
		employeeDB.add(e2);
		employeeDB.add(e3);
		employeeDB.add(e4);
		
	}

	public boolean addEmployee(Employee e)
	{
		System.out.println("--->> 2) list.size() :- "+employeeDB.size() + " - "+e);
		boolean status =  employeeDB.add(e);
		
		System.err.println("--->> 3) inside Employee DB "+status);
		
		return status;
	}
		
	
	
	public static Employee getEmployee(int id)
	{
		List<Employee> list =   employeeDB.stream().filter((e)->{
			if(e.getEmpId() == id)
			{
				return true;
			}
			else return false;
		}).collect(Collectors.toList());
		
		if(list.size()==1)	return list.get(0);
		else return null;
		
	}
	
	public static Employee getEmployee(String name)
	{
		List<Employee> list =   employeeDB.stream().filter((e)->{
			if(e.getName().equalsIgnoreCase(name))
			{
				return true;
			}
			else return false;
		}).collect(Collectors.toList());
		
		if(list.size()==1)	return list.get(0);
		else return null;
		
	}
	public static List<Employee> getEmployeeDB() {
		return employeeDB;
	}

	
	public static List<Employee> getEmployee (int range1, int range2){
		List<Employee> salaryList=new ArrayList<>();
		for(Employee e:employeeDB) {
			if(e.getSalary()==range1||e.getSalary()==range2) {
				salaryList.add(e);
			}
		}
	
		return salaryList;
	
	}
	
	public static Employee updateProjectInfo(int searchId,int projectId)
	{
		
		
		Employee empFromDB = getEmployee(searchId);
		
		if(empFromDB != null)
		{
			empFromDB.setProjectInfo(projectId);
			return empFromDB;
		}
		
		
		
		return null;
	}
	
	public static Employee getProject(int empId, int projectId) {
		Employee empFromDB = getEmployee(empId);
		
		if(empFromDB != null)
		{
			if(empFromDB.getProjectInfo()==projectId) {
				return empFromDB;
			}
			
		}
		return null;
	}
	
	public static void setEmployeeDB(List<Employee> employeeDB) {
		EmployeeDB.employeeDB = employeeDB;
	}
	
	
	
	
}*/