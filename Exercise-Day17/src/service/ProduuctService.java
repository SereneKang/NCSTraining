package service;

import java.sql.SQLException;
import java.util.List;

import model.Product;

public interface ProduuctService {
	public List<Product> getAllProduct()throws SQLException;
}
