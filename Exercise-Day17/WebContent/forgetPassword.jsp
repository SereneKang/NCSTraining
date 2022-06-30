<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="text-align:center">Change Password</h2>
<form action="ResetPassword" method="post">
Username <input type="text" name="resetUsedname"><br/><br/>
Security Question 
	<select name="securityQuestion">
		<option>What is your nickname? </option>
		<option>What is your mother name? </option>
		<option>What is your father name? </option>
		<option>What is the name of your high school? </option>
	</select><br/><br/>
	Security Answer <input type="text" name="securityAnswer"><br/><br/>
	New Password <input type="text" name="newPassword"><br/><br/>
	<div style="text-align:center">
	<input type="submit" value="Change Password"><br/><br/>
	</div>
</form>

</body>
</html>