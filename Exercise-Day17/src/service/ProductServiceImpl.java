package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

public class ProductServiceImpl implements ProduuctService {

	ProductDAO productDAO;
	
	public ProductServiceImpl() {
		productDAO=new ProductDAOImpl();
	}
	
	@Override
	public List<Product> getAllProduct()throws SQLException {
		
		return productDAO.getAllProduct();
	}

}
