package com.ncs.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncs.model.Employee;
import com.ncs.service.EmployeeService;
import com.ncs.service.EmployeeServiceImpl;

/**
 * Servlet implementation class ViewAllEmployeeServlet
 */
public class ViewAllEmployeeServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter browser = resp.getWriter();
		
		EmployeeService empService = new EmployeeServiceImpl();
		
		try {
			
			List<Employee> allEmployees = empService.getAllEmploye();
			
			if(allEmployees != null)
			{
				printEmployees(allEmployees,browser);
			}
			else
			{
				browser.print("Add Employee in the Database");
			}
			
			
		} catch (Exception e) {
			browser.print("Exception :- "+e);
		}
			
		
		
		
	}
	
	void printEmployees(List<Employee> list,PrintWriter browser)
	{
		
		browser.print("<html>");
		browser.print("<body>");
		browser.print("<table>");
		
		for (Employee employee : list) {
			browser.print("<tr>");
			
			browser.print("<td>"+employee.getEmpId()+"</td>");
			browser.print("<td>"+employee.getName()+"</td>");
			browser.print("<td>"+employee.getProjectInfo()+"</td>");
			browser.print("<td>"+employee.getEmail()+"</td>");
			browser.print("<td>"+employee.getBankAccount()+"</td>");
			browser.print("<td>"+employee.getDesignation()+"</td>");
			browser.print("<td>"+employee.getAddress()+"</td>");
			browser.print("<td>"+employee.getSalary()+"</td>");
			
			browser.print("<td> <a href='#'> edit </a> </td>");
			browser.print("<td> <a href='#'> delet </a></td>");
			
					
			browser.print("<tr>");
		}// end of for fr <tr>
		
		browser.print("</table>");
		browser.print("</body></html>");
		
		
		
		
		
	}

}








