<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=(String)session.getAttribute("username");
%>
<div style="background-color: yellow; width: 100%;height: 100px">
	<div style="margin-left: 75%;margin-bottom:30px; font-size:medium; color:black;">
		Welcome <%=name%>
		
	</div>
	<div style="margin-left: 75%; font-size:medium">
	<a href="forgetPassword.jsp">update Password</a>
	</div>
	<div style="margin-left: 75%; font-size:medium">
	<a href="showCart.jsp">Cart List</a>
	</div>
</div>
</body>
</html>