<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Login Page</h3>
<h4 style="color:red">${user1}</h4>
<form action="loginControl" method="post">

<form:message code="name"/><input type="text" name="username"><br>

<form:message code="password"/><input type="password" name="userpassword"><br>

<input type="submit" value="login">

</form>

</body>
</html>