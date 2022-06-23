package loginChecking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginChecking
 */
public class loginChecking extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter browser=resp.getWriter();
		
		String user=req.getParameter("username");
		String pass=req.getParameter("password");
		
		if(user.equals("serene")&&pass.equals("123")) {
			//browser.print("<br>Welcome: "+user);
			//redirect to menu 
			resp.sendRedirect("menu.html");
		}else {
			browser.print("<b><br>Invalid User</b> ");
		}
	}

}
