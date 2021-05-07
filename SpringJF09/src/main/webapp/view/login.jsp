<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Login Page</h3>
<h4 style="color:red">${user}</h4>
<form action="loginControl" method="post">
name:<input type="text" name="username"><br>
password:<input type="password" name="userpassword"><br>
<input type="submit" value="login">

</form>

</body>
</html>