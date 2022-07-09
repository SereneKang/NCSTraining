package com.ncs.empconsole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.empconsole.model.Department;
import com.ncs.empconsole.repository.DepartmentRepository;
import com.ncs.empconsole.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Override
	public Department addDepartment(Department department) {
		
		Department savedEntity = departmentRepository.save(department);
		return savedEntity;
	}

	@Override
	public List<Department> getAllDepartments() {
		
		
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentByCode(int dCode) {
		
		return departmentRepository.findById(dCode).get();
	}

	@Override
	public boolean deleteDepartment(int dcode) {
		System.err.println("---> 1. inside department service ");
		Department d=departmentRepository.findById(dcode).get();
		departmentRepository.deleteDepartment(d);
		departmentRepository.deleteById(dcode);
		boolean status=departmentRepository.existsById(dcode);
		System.err.println("---> 3. done updateQuery");
		return status;
	}


	

	
}