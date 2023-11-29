<%@page import="com.java.lms.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.java.lms.EmployeeDAOImpl"%>
<%@page import="com.java.lms.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% EmployeeDAO dao= new EmployeeDAOImpl();
		List<Employee> employtList= dao.showEmployeeDao();
	%>
</body>
</html>