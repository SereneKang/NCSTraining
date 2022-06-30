package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.ShoppingItem;
import model.User;
import service.ProductServiceImpl;
import service.ProduuctService;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet extends HttpServlet {

	private static final String CART_ATTRIBUTE="cart";
	List<Product> products=new ArrayList<>();
	UserService userService=new UserServiceImpl();
	
	
	@Override
	public void init() throws ServletException {
		ProduuctService productService=new ProductServiceImpl();
		List<Product> allProduct;
		try {
			allProduct = productService.getAllProduct();
			for(Product p:allProduct)
			{
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int productId=0;
		int quantity=1;
		boolean status = false;
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		productId=Integer.parseInt(req.getParameter("productId"));

		Product product=getProduct(productId);
		if(product!=null && quantity>=0) {
			ShoppingItem shoppingItem=new ShoppingItem(product,quantity);
			HttpSession session=req.getSession(false);
			List<ShoppingItem> cart=(List<ShoppingItem>)session.getAttribute(CART_ATTRIBUTE);	
			int id=(int) session.getAttribute("userId");
			int index=-2;
			if(cart==null) {
				
				cart=new ArrayList<ShoppingItem>();
				cart.add(shoppingItem);
				session.setAttribute(CART_ATTRIBUTE, cart);
				
			}else {
				index=isExisting(productId,cart);
				if(index==-1) {
					cart.add(shoppingItem);			
				}else {
					quantity=cart.get(index).getQuantity()+1;
					cart.get(index).setQuantity(quantity);

				}	
			}
			session.setAttribute(CART_ATTRIBUTE, cart);
			if(cart!=null) {
				if(index==-1||index==-2) {
					try {
					
						boolean saveStatus = userService.saveCart(cart,id);
						if(saveStatus) {
							//showProductList(req,resp);
							resp.sendRedirect("showCart.jsp");
						}else {
							out.print("Can't Save To Database !! ");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					try {
						
						boolean updateStatus=userService.updateCart(id,productId,quantity);
						if(updateStatus) {
							//showProductList(req,resp);
							resp.sendRedirect("showCart.jsp");
						}else {
							out.print("Can't Update To Database !! ");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		
		}
		
		
	}
	
	
	
	private int isExisting(int id,List<ShoppingItem> cart) {
		for(int i=0;i<cart.size();i++) {
			if(cart.get(i).getProduct().getProductId()==id)
				return i;
		}
		return -1;
	}
	
	private void showProductList(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		List<ShoppingItem> cart=(List<ShoppingItem>)session.getAttribute(CART_ATTRIBUTE);
		
		if(cart!=null) 
		out.print("<table rules=\"all\" >");
		out.print("<tr>");
		out.print("<th style=\"padding:10px\"> ID </th>");
		out.print("<th style=\"padding:10px\"> Model </th>");
		out.print("<th style=\"padding:10px\"> Hard Drive </th>");
		out.print("<th style=\"padding:10px\"> Memory </th>");
		out.print("<th style=\"padding:10px\"> Price (SGD) </th>");
		out.print("<th style=\"padding:10px\"> Quantity </th>");
		out.print("</tr>");

		{
			for(ShoppingItem si:cart)
			{
				out.print("<tr>");
				out.print("<td>"+si.getProduct().getProductId()+"</td>");
				out.print("<td>"+si.getProduct().getProductModel()+"</td>");
				out.print("<td>"+si.getProduct().getHardDrive()+"</td>");
				out.print("<td>"+si.getProduct().getMemory()+"</td>");
				out.print("<td>"+si.getProduct().getPrice()+"</td>");
				out.print("<td>"+si.getQuantity()+"</td>");
				out.print("</tr>");
			}
		}
		out.print("</table>");
		
	}
	
	private Product getProduct(int productId) {
		for(Product p:products) {
			if(p.getProductId()==productId) {
				return p;
			}
		}
		return null;
	}

}
