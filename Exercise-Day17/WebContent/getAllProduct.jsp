
<%@page import="service.ProductServiceImpl"%>
<%@page import="service.ProduuctService"%>
<%@page import="java.util.*"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th style="padding:10px"> ID </th>
<th style="padding:10px"> Model </th>
<th style="padding:10px"> Hard Drive </th>
<th style="padding:10px"> Memory </th>
<th style="padding:10px"> Price (SGD) </th>
</tr>
<%

ProduuctService productService=new ProductServiceImpl();
List<Product> allProduct=productService.getAllProduct();

for(Product p:allProduct)
{
	%>
	<tr>
				<td><%= p.getProductId()%></td>
				<td><%=p.getProductModel()%></td>
				<td><%=p.getHardDrive() %></td>
				<td><%=p.getMemory()%></td>
				<td><%=p.getPrice() %></td>
				<td> <a href='AddToCartServlet?productId=<%=p.getProductId()%>'> Add To Cart </a> </td>
			
	</tr>
	<%
}
%>
</table>
<!-- <hr/>
from application scope 
<hr/>
<%
//List<Product> allProduct2= (List<Product>)application.getAttribute("allProducts");
//out.print(allProduct2);

%> -->

</body>
</html>

