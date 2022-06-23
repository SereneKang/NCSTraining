package com.ncs.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncs.model.Employee;
import com.ncs.service.EmployeeService;
import com.ncs.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AddEmployeeServlet
 */
public class AddEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeService empService = new EmployeeServiceImpl();
		
		resp.setContentType("text/html");
		PrintWriter browser=resp.getWriter();
		
		int empId=Integer.parseInt(req.getParameter("empId"));
		String empName=req.getParameter("empName");
		int projectInfo=Integer.parseInt(req.getParameter("projectInfo"));
		String email=req.getParameter("email");
		int bankAccount=Integer.parseInt(req.getParameter("bankAccount"));
		String address=req.getParameter("address");
		String designation=req.getParameter("designation");
		int salary=Integer.parseInt(req.getParameter("salary"));
		
		Employee e=new Employee(empId,empName,projectInfo,email,bankAccount, address, designation, salary);
		try {
			boolean status=empService.saveEmployee(e);
			if(status) {
				browser.print("Employee "+e.getEmpId()+" - "+e.getName()+" added successfully !");
				//resp.sendRedirect("menu.html");
			}else {
				browser.print("Cannot add !!! ");
			}
		} catch (SQLException e1) {
			
			browser.print("Exception :- "+e1);
		}
	}

}
