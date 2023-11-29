<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.java.jsp.Employ"%>
<%@page import="java.util.List"%>
<%@page import="com.java.jsp.EmployDAOImpl"%>
<%@page import="com.java.jsp.EmployDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		EmployDAO dao= new EmployDAOImpl();
		List<Employ> employList= dao.showEmployDao();
	%>
	
	<table border="2" align="center">
		<tr>
			<th>Employ No</th>
			<th>Employ Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>
		</tr>
		<% for(Employ employ: employList){ %>
		<tr>
				<th><%= employ.getEmpno() %></th>
				<th><%= employ.getName() %></th>
				<th><%= employ.getGender() %></th>
				<th><%= employ.getDept() %></th>
				<th><%= employ.getDesig() %></th>
				<th><%= employ.getBasic() %></th>
		</tr>
		<% } %>
	</table>
</body>
</html>