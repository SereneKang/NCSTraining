package com.ncs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ncs.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection con;
	
	public EmployeeDAOImpl() {
		
		con = MySQLConnection.mySql;
	}
	
	@Override
	public boolean saveEmployee(Employee e) throws SQLException{
		
		/* code should be responsible to 
		 * 1) insert employee into DB 
		 * 2) return the status value*/
		
		String query = "insert into ncsemployee values (?,?,?,?,?,?,?,?);";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(3, e.getProjectInfo());
		ps.setInt(1, e.getEmpId());
		ps.setString(2,e.getName());
		ps.setString(4, e.getEmail());
		ps.setInt(5, e.getBankAccount());
		ps.setString(6,e.getAddress());
		ps.setString(7, e.getDesignation());
		ps.setInt(8,e.getSalary());
		
		int rowsEffected = ps.executeUpdate();
		
		boolean status = (rowsEffected > 0)?true:false;
		
		return status;
	}

	@Override
	public Employee getEmployeeByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmploye() throws SQLException{
		
		String getAllEmployee = "select * from NCSEmployee";
		PreparedStatement ps = con.prepareStatement(getAllEmployee);
		ResultSet rs = ps.executeQuery();
		
		if(rs!=null)
		{
			List<Employee> allEmployees = new ArrayList<>();
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int projectinfo = rs.getInt(3);
				String email = rs.getString(4);
				int bankAccount = rs.getInt(5);
				String address = rs.getString(6);
				String designation = rs.getString(7);
				int salary = rs.getInt(8);
				
				Employee e = new Employee(id, name, projectinfo, email, bankAccount, address, designation, salary);
				allEmployees.add(e);
			}
			
			if(allEmployees.size()>0) return allEmployees;
			else return null;
		}
		
		
		return null;
	}

	@Override
	public Employee doLinkProjectWithEmployee(int empId, int projetId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}