package com.ncs.empconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.empconsole.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>,CustomEmployeeRepository
{

	
}