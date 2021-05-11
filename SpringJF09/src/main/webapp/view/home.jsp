<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${user1}

<table>
<tr>
<td><a href="register">Register Employee</a></td>
<td><a href="update">Update Employee</a></td>
<td><a href="delete">Delete Employee</a></td>
<td><a href="showAll">All Employees</a></td>
<td><a href="searchEmployee">Search Employee</a></td>
</tr>
</table>

<c:if test="${not empty name}">

<h4>${name} is registered successfully</h4>

</c:if> 

<c:if test="${not empty list}">
<table>
<c:forEach var="e" items="${list}">
  <tr><td>${e.id}</td><td>${e.name}</td><td>${e.salary}</td></tr>
</c:forEach>
</table>
</c:if>

<c:if test="${not empty find}">

<h4>${find}</h4>
<form action="findEmployee">
Enter id:<input type="text" name="id"><br>
<input type="submit" value="submit">
</form>

</c:if> 

<c:if test="${not empty emp1}">

<table>

  <tr><td>${emp1.id}</td><td>${emp1.name}</td><td>${emp1.salary}</td></tr>

</table>


</c:if> 

${noEmp}

</body>
</html>