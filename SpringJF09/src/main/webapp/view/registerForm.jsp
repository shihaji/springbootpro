<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  .error{
    color:red;
  }
</style>
</head>
<body>

<h4>Register Employee</h4>

<form:form modelAttribute="employee" method="post" action="employeeRegister">
id:<form:input path="id"/> <form:errors path="id" cssClass="error"/><br>
name:<form:input path="name"/><form:errors path="name" cssClass="error"/><br>
salary:<form:input path="salary"/><form:errors path="salary" cssClass="error"/><br>
desg:<form:select path="desg">
		<form:option value="">Select Desg</form:option>
		<form:options items="${roles}"/>
</form:select><br>
doj:<form:input path="doj"/><form:errors path="doj" cssClass="error"/><br>
<input type="submit" value="register"/>
</form:form>



</body>
</html>