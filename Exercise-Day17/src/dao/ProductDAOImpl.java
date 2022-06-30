package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Product;

public class ProductDAOImpl implements ProductDAO {
	Connection con;
	
	public ProductDAOImpl() {
		con=MyDatabase.mySql;
	}
	
	@Override
	public List<Product> getAllProduct()throws SQLException {
		List<Product> productList=new ArrayList<>();
		String query="select * from product";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				int productId=rs.getInt(1);
				String productModel=rs.getString(2);
				String productHardDrive=rs.getString(3);
				String productMemory=rs.getString(4);
				int price=rs.getInt(5);
				
				Product p=new Product(productId,productModel,productHardDrive,productMemory,price);
				productList.add(p);
			}
		}
		
		return productList;
	}

}
