package service;

import java.sql.SQLException;
import java.util.List;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.Product;
import model.ShoppingItem;
import model.User;

public class UserServiceImpl implements UserService{

	UserDAO userDao;
	public UserServiceImpl() {
		userDao=new UserDAOImpl();
	}
	
	@Override
	public boolean saveUser(User u) throws SQLException {
		
		return userDao.saveUser(u);
	}

	@Override
	public List<Product> getAllProduct() throws SQLException {
		
		return null;
	}

	@Override
	public List<User> getAllUser() throws SQLException {
		
		return userDao.getAllUser();
	}

	@Override
	public boolean setNewPass(String userName,String password) throws SQLException {
		
		return userDao.setNewPass(userName,password);
	}

	@Override
	public boolean saveCart(List<ShoppingItem> si,int id) throws SQLException {
		
		return userDao.saveCart(si, id);
	}

	@Override
	public boolean updateCart(int UserId,int ProductId,int quantity)throws SQLException{
		
		return userDao.updateCart(UserId, ProductId, quantity);
	}



	

}
