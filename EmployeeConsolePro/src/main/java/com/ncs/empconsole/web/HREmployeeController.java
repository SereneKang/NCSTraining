package com.ncs.empconsole.web;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

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
import com.ncs.empconsole.model.Department;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.model.Laptop;
import com.ncs.empconsole.model.Project;
import com.ncs.empconsole.service.DepartmentService;
import com.ncs.empconsole.service.EmployeeService;
import com.ncs.empconsole.service.LaptopService;
import com.ncs.empconsole.service.ProjectService;

@RestController
@RequestMapping("/empconsole/hr")
public class HREmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	LaptopService laptopService;
	
	@Autowired
	ProjectService projectService;
	
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
	
	
	@PostMapping("/department")
	public Department addDepartment(@RequestBody Department department)
	{
		return departmentService.addDepartment(department);
	}
	
	@GetMapping("/department/{dCode}")
	public Department getDepartmentById(@PathVariable int dCode)
	{
		return departmentService.getDepartmentByCode(dCode);
	}
	
	@PutMapping("/employee/{searchEmpId}/department")
	public Employee updateEmployeeDepartment(@PathVariable int searchEmpId,@RequestParam int dcode)
	{
		System.out.println(" HR @ REST Controller ");
		System.out.println(" Searched Emp Id :- "+searchEmpId);
		System.out.println("D code "+dcode);
		Department d = departmentService.getDepartmentByCode(dcode);
		
		if(d != null)
		{
			System.out.println("--->> inside d "+d);
			Employee e = empService.updateDepartment(searchEmpId, d);
			return e;
		}
		
		return null;
	}
	
	@PostMapping("/laptop")
	public Laptop addLaptop(@RequestBody Laptop laptop) {
		return laptopService.addLaptop(laptop);
	}
	
	@GetMapping("/laptop/{lcode}")
	public Laptop getLaptopById(@PathVariable int lcode) {
		return laptopService.getLaptopById(lcode);
	}
	
	@PutMapping("/employee/{eID}/l3aptop")
	public Employee updateEmpLaptop(@PathVariable int eID, @RequestParam int lcode) {
		
		Laptop l=laptopService.getLaptopById(lcode);
		
		if(l!=null) {
			Employee e=empService.updateLaptop(eID, l);
			return e;
		}
		return null;
	}
	

	@GetMapping("/departments")
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/laptops")
	public List<Laptop> getAllLaptop(){
		return laptopService.getAllLaptop();
	}
	
	@PostMapping("/project")
	public Project addProject(@RequestBody Project project)
	{
		return projectService.addProject(project);
	}
	
	@GetMapping("/project/{pid}")
	public ResponseEntity<Project> getProjetById(@PathVariable int pid)throws Exception
	{
		Project p =  projectService.getProject(pid);
		if(p != null)
		{
			return new ResponseEntity<Project>(p,HttpStatus.OK);
		}
		else
		{
			throw new Exception("Invalid Project ID");
		}
	}
	
	@PutMapping("/project/{pid}")
	public ResponseEntity<Set<Employee>> allocateEmployeeToProject(@PathVariable int pid, @RequestParam int empId)throws Exception
	{
		 Set<Employee> workingEmployee = null;
		 
		  
		 Employee e = empService.getEmployeeDetails(empId);
		 Project p = projectService.getProject(pid);
		 
		 // write exception handling code if e or p is null
		 
		 if(e != null & p != null)
		 {
			 workingEmployee = projectService.allocateProject(p, e);
			 return new ResponseEntity<Set<Employee>>(workingEmployee,HttpStatus.OK);
		 }
		 else 
		 {
			 throw new Exception("Invalid Project ID or no Employee Allocated");
		 }
		 
	}
	
	@GetMapping("/project/{pid}/employees")
	public ResponseEntity<Set<Employee>> getAllWorkingEmployees(@PathVariable int pid)throws Exception
	{
		Set<Employee> workingEmployees =  projectService.getProjectResource(pid);
		
		if(workingEmployees!=null || workingEmployees.size()>0)
		{
			 return new ResponseEntity<Set<Employee>>(workingEmployees,HttpStatus.OK);
		}
		 else 
		 {
			 throw new Exception("Invalid Project ID or no Employee Allocated");
		 }
	}
	
}//end class