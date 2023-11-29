<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Login.jsp">
<center>
<h2>Please Login :</h2>
UserName : <input type="text" name="userName" size="50"> <br/><br/>
Password : <input type="password" name="password" size="50"> <br/><br/>
<input type="submit" value="Login">
</center>
</form>
<c:if test="${param.userName!=null && param.password!=null}">
	<jsp:useBean id="login" class="com.java.library.LibUsers"/>
	<jsp:setProperty property="*" name="login"/>
	<jsp:useBean id="dao" class="com.java.library.LibraryDAOImpl"/>
	<c:set var="count" value="${dao.authenticate(login)}"/>
	<c:if test="${count==1}">
		<%
			session.setAttribute("user", request.getParameter("userName"));
		%>
		<jsp:forward page="Menu.jsp"/>
	</c:if>
	<c:if test="${count==0}">
		<c:out value="Invalid Credentials..."/>
	</c:if>
	
</c:if>
</body>
</html>