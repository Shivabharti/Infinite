<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Search Agent</title>

</head>

<body>

	<form method="get" action="SearchAgent.jsp">

		<center>

			Agent Id : <input type="number" name="AgentID" /> <br /> <br />
			<input type="submit" value="Search Agent" />

		</center>

	</form>



	<c:if test="${param.AgentID!=null}">

		<sql:setDataSource var="connection" driver="com.mysql.cj.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/exam" user="root"
			password="rootroot" />



		<sql:query var="agentQuery" dataSource="${connection}">

            SELECT * FROM Agent WHERE AgentID=?

            <sql:param value="${param.AgentID}" />

		</sql:query>



		<c:if test="${not empty agentQuery.rows}">

			<c:forEach var="agent" items="${agentQuery.rows}">

                Agent Id :

                <c:out value="${agent.AgentID}" />
				<br />
				<br />

                Agent Name :

                <c:out value="${agent.Name}" />
				<br />
				<br />

                Gender :

                <c:out value="${agent.gender}" />
				<br />
				<br />

                City :

                <c:out value="${agent.City}" />
				<br />
				<br />

                Marital Status :

                <c:out value="${agent.MaritalStatus}" />
				<br />
				<br />

                Premium :

                <c:out value="${agent.Premium}" />
				<br />
				<br />

			</c:forEach>

		</c:if>

		<c:if test="${empty agentQuery.rows}">

			<c:out value="No Agent found with Agent ID: ${param.AgentID}" />

		</c:if>

	</c:if>

</body>

</html>