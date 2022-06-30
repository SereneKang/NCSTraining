package service;

import java.sql.SQLException;
import java.util.List;

import model.Product;
import model.ShoppingItem;
import model.User;

public interface UserService {
	public boolean saveUser(User u)throws SQLException;
	public List<Product>getAllProduct()throws SQLException;
	public List<User>getAllUser()throws SQLException;
	public  boolean setNewPass(String userName,String password) throws SQLException;
	public boolean saveCart(List<ShoppingItem> si,int id)throws SQLException;
	public boolean updateCart(int UserId,int ProductId,int quantity)throws SQLException;
}
