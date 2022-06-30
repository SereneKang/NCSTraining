package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xml.internal.serializer.EmptySerializer;

import model.User;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class ResetPassword
 */
public class ResetPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		boolean updatedStatus=false;
		resp.setContentType("text/html");
		PrintWriter browser = resp.getWriter();
		
		String name=req.getParameter("resetUsedname").trim();
		String question=req.getParameter("securityQuestion").trim();
		String answer=req.getParameter("securityAnswer").trim();
		String newPass=req.getParameter("newPassword").trim();
		
		
		UserService userService=new UserServiceImpl();
		
		try {
			List<User> getUser=userService.getAllUser();
			for(User user:getUser) {
				if(user.getUsername().equals(name)&&user.getSecurityQuestion().equals(question)&&user.getSecurityQuestionAns().equals(answer)) {
						updatedStatus=userService.setNewPass(name,newPass);
						
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(updatedStatus) {
			browser.print("<h2 style=\"text-align:center\" >Update Successfully !! </h2>");
			browser.print("<br/><br/><a href=\"LoginPage.jsp\" >Go to Login Page</a> ");
		}else {
			browser.print("<h2 style=\"text-align:center\" style=\"color:red\">Something wrong.. </h2>");
			browser.print("<br/><br/><a href=\"forgetPassword.jsp\" >Go back to Reset Password Page</a> ");
		}
		
	}
}
