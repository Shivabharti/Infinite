<%@page import="java.util.ArrayList"%>
<%@page import="com.java.agent.Agent"%>
<%@page import="java.util.List"%>
<%@page import="com.java.agent.AgentDAOImpl"%>
<%@page import="com.java.agent.AgentDAO"%>
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
	AgentDAO dao = new AgentDAOImpl();
	List<Agent> agentList = dao.showAgentDao();
	%>
	<table border="2" align="center">
		<tr>
			<th>Agent Id</th>
			<th>Agent Name</th>
			<th>City</th>
			<th>Gender</th>
			<th>Marital Status</th>
			<th>Premium</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		for (Agent agent : agentList) {
		%>
		<tr>
			<th><%=agent.getAgentId()%></th>
			<th><%=agent.getName()%></th>
			<th><%=agent.getCity()%></th>
			<th><%=agent.getGender()%></th>
			<th><%=agent.getMaritalStatus()%></th>
			<th><%=agent.getPremium()%></th>
			<th><a href=UpdateAgent.jsp?agentId=<%=agent.getAgentId()%>>
					Update</a></th>
			<th><a href="DeleteAgent.jsp?agentId=<%=agent.getAgentId()%>">Delete</a>
		</tr>
		<%
		}
		%>
	</table><HR/>
		<a href="AddAgent.jsp">Add Agent</a>
</body>
</html>