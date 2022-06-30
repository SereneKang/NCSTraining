package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import model.Product;
import model.User;
import service.ProductServiceImpl;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class LoginChecking
 */
public class LoginChecking extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isValidUser=false;
		int userId=0;
		
		String username=req.getParameter("username").trim();
		String password=req.getParameter("password").trim();

		
		UserService userService=new UserServiceImpl();
		try {
			
			// just to load all products in application scope , so we can access any time
			/*ServletContext contxt = getServletContext();
			List<Product> allProducts = new ProductServiceImpl().getAllProduct();
			
			contxt.setAttribute("allProducts", allProducts);*/
	
			List<User> getUser=userService.getAllUser();
			for(User user:getUser) {
				if(user.getUsername().equalsIgnoreCase(username)&&user.getPassword().equals(password)) {
					userId=user.getUserId();
					isValidUser=true;
				}
			}
			
			if(isValidUser) {
				HttpSession session=req.getSession(true);
				session.setAttribute("username", username);
				session.setAttribute("userId",userId );
				resp.sendRedirect("HomePage.jsp");
			}
			else {
				resp.sendRedirect("LoginPage.jsp");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
