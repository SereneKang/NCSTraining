<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 style="text-align:center">Welcome To Login</h2>
	<form action="LoginChecking" method="post">
	Username <input type="text" name="username"><br/><br/>
	Password <input type="text" name="password"><br/><br/>
	<div style="text-align:center">
	<input type="submit" value="Login"><br/><br/>
	</div>
	
	
	<a href="register.jsp" >Register user</a>           	<a href="forgetPassword.jsp" style="position:absolute; right:10px">Forgot Password</a>  

	</form>
</body>
</html>