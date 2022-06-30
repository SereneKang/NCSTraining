package dao;

import java.sql.SQLException;
import java.util.List;

import model.Product;

public interface ProductDAO {
	public List<Product> getAllProduct()throws SQLException;

}
