package com.ncs.empconsole.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Employee;

import com.ncs.empconsole.service.EmployeeService;

@RestController
@RequestMapping("/empconsole/hr")
public class HREmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	public HREmployeeController() {
		System.out.println("HR Employee Controller constructor called");
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}

	@GetMapping("/employee/id/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)throws IllegalArgumentException,NoSuchElementException
	{
		System.out.println("path varible : "+id);
		try {
			Employee output = empService.getEmployeeDetails(id);
			return new ResponseEntity<Employee>(output,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(" --->> inside catch ");
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	@GetMapping("/employee") // ..../employee/hr/employee?name=ramesh
	public ResponseEntity<Employee> getEmployeeByName(@RequestParam String name)throws NoSuchElementException
	{
		System.out.println("path varible : "+name);
		try {
			Employee e =  empService.getEmployeeDetails(name);
			return new ResponseEntity<Employee>(e,HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(" --->> inside catch ");
			throw new NoSuchElementException(e.getMessage());
		}
	
	}
	
	@GetMapping("/employeeSalary")
	public List<Employee> getSalary(@RequestParam int range1,int range2){
		List<Employee> list=empService.getAllEmployees(range1, range2);
		return list;
		
	}
	
	@GetMapping("/employee/{empId}/project")
	public Employee getEmployee(@PathVariable int empId,@RequestParam int projectId)
	{
		return empService.getProject(empId, projectId);
	}
	
	@PutMapping("/employee/{searchEmpId}/project")
	public Employee updateEmployee(@PathVariable int searchEmpId,@RequestParam int projectId)
	{
		return empService.updateProject(searchEmpId, projectId);
	}
	
	@PostMapping("/employee") //http://localhost:8081/empconsole/hr/employee
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e)throws OutofRangeSalaryException
	{
		
		Employee savedEmployee = empService.addEmployee(e);
		
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
		
	}
	

	@DeleteMapping("/employeeDelete/{id}")
	public String deleteEmpByID(@PathVariable int id) {
		
		String noti=null; 
		boolean status=empService.deleteEmpById(id);
		if(!status) {
			noti="Delete successfully!";
		}else {
			noti="Something wrong....";
		}
		return noti;
		
	}
	
}//end class