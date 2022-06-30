package dao;

import java.sql.*;
import java.util.*;

import model.Product;
import model.ShoppingItem;
import model.User;

public class UserDAOImpl implements UserDAO {
	Connection con;

	
	public UserDAOImpl() {
		con=MyDatabase.mySql;
		
	}
	@Override
	public boolean saveUser(User u) throws SQLException {
		String query="insert into user (userId,username,password,securityQuestion,securityAnswer) values (?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, u.getUserId());
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getPassword());
		ps.setString(4, u.getSecurityQuestion());
		ps.setString(5, u.getSecurityQuestionAns());

		int rowEffected=ps.executeUpdate();
		boolean status=(rowEffected>0)?true:false;
		return status;
	}

	@Override
	public List<Product> getAllProduct() throws SQLException {
	
		return null;
	}

	@Override
	public List<User> getAllUser() throws SQLException {
		List<User> userList=new ArrayList<>();
		String getAllUser = "select * from user";
		PreparedStatement ps=con.prepareStatement(getAllUser);
		ResultSet rs=ps.executeQuery();
		if(rs!=null) {
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String pass=rs.getString(3);
				String question=rs.getString(4);
				String answer=rs.getString(5);
				
				User u=new User(id,name, pass,question,answer);
				userList.add(u);
			}
		}
		
		return userList;
	}
	@Override
	public boolean setNewPass(String userName,String password) throws SQLException {
		User u=null;
		String query="update user set password = ? where username = ?";
		boolean status=false;
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, password);
		ps.setString(2,userName);
		int rowEffected=ps.executeUpdate();
		if(rowEffected>0) {
			System.out.println("Password Updated successfully !!");
			status=true;
		}else {
			System.err.println("Something wrong !!");
			status=false;
		}
		
		return status;
	}
	@Override
	public boolean saveCart(List<ShoppingItem> si,int userId) throws SQLException {
		String query="insert into cartlist values (?,?,?);";
		int productId=0,quantity = 0;
		PreparedStatement ps=con.prepareStatement(query);
		for(ShoppingItem t:si) {
			productId=t.getProduct().getProductId();
			quantity=t.getQuantity();
		}
		ps.setInt(1, userId);
		ps.setInt(2, productId);
		ps.setInt(3, quantity);

		int rowEffected=ps.executeUpdate();
		boolean status=(rowEffected>0)?true:false;
		return status;
	}
	@Override
	public boolean updateCart(int UserId, int ProductId, int quantity) throws SQLException {
		String query="update cartlist set quantity = ? where (userId=? and productId=?)";
		PreparedStatement ps=con.prepareStatement(query);
	
		ps.setInt(2, UserId);
		ps.setInt(1, quantity);
		ps.setInt(3, ProductId);

		int rowEffected=ps.executeUpdate();
		boolean status=(rowEffected>0)?true:false;
		return status;
	}
	
	
	

	


}
