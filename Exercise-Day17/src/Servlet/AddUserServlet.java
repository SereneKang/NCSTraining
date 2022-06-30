package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	Random random = new Random();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService=new UserServiceImpl();
		int userId=random.nextInt(100);
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String question=req.getParameter("Question");
		String answer=req.getParameter("answer");
		User u=new User(userId,username,password,question,answer);
		try {
			boolean status=userService.saveUser(u);
			if(status) {
				resp.sendRedirect("LoginPage.jsp");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
