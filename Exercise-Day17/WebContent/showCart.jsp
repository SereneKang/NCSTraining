<%@page import="java.util.*"%>
<%@page import="model.ShoppingItem"%>
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
<th style="padding:10px"> Quantity </th>
</tr>

<% 
List<ShoppingItem> cart=(List<ShoppingItem>)session.getAttribute("cart");
for(ShoppingItem i:cart){
	%>
		<tr>
				<td><%=i.getProduct().getProductId()%></td>
				<td><%=i.getProduct().getProductModel()%></td>
				<td><%=i.getProduct().getHardDrive() %></td>
				<td><%=i.getProduct().getMemory()%></td>
				<td><%=i.getProduct().getPrice() %></td>
				<td><%=i.getQuantity() %></td>
		
	</tr>
	<%
}
%>
</table>


</body>
</html>