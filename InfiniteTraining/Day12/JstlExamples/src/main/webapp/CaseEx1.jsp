<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="x" value="1" />
	<c:choose>
	<c:when test="${x==1}">
	<c:out value="Shivangi"/>
	</c:when>
	<c:when test="${x==2}">
	<c:out value="Shirisha"/>
	</c:when>
	<c:when test="${x==3}">
	<c:out value="Sanjay"/>
	</c:when>
	<c:when test="${x==4}">
	<c:out value="Satya"/>
	</c:when>
	<c:otherwise>
	<c:out value="Sweta"/>
	</c:otherwise>
	</c:choose>
</body>
</html>