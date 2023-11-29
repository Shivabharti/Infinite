<%@page import="com.java.agent.Gender"%>
<%@page import="com.java.agent.Agent"%>
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
	int agentId = Integer.parseInt(request.getParameter("agentId"));
	AgentDAO dao = new AgentDAOImpl();
	Agent agent = dao.searchAgentDao(agentId);
	%>
	<form method="get" action="UpdateAgent.jsp">
		<center>
			Agent No : <input type="number" name="agentId" readonly="readonly"
				value=<%=agent.getAgentId()%> /> <br /> <br /> 
			Agent Name : <input type="text" name="name" value=<%=agent.getName()%> /> <br /> <br />
			City: <input type="text" name="city" /> <br/><br/>
			Gender : <input type="text" name="gender" value=<%=agent.getGender()%> /> <br /> <br />
			MaritalStatus: <input type="text" name="maritalStatus" value=<%=agent.getMaritalStatus()%> /><br /> <br />
			Premium : <input type="number" name="premium"
				value=<%=agent.getPremium()%> /> <br /> <br />
				<input type="submit" value="Update Agent" />
		</center>
	</form>
	<%
	if (request.getParameter("agentId") != null && request.getParameter("premium") != null) {
		Agent agentUpdate = new Agent();
		agentUpdate.setAgentId(Integer.parseInt(request.getParameter("agentId")));
		agentUpdate.setName(request.getParameter("name"));
		agentUpdate.setCity(request.getParameter("city"));
		agentUpdate.setGender(Gender.valueOf(request.getParameter("gender")));
		agentUpdate.setMaritalStatus(Integer.parseInt(request.getParameter("maritalStatus")));
		agentUpdate.setPremium(Double.parseDouble(request.getParameter("premium")));
		dao.updateAgentDao(agentUpdate);
	%>
	<jsp:forward page="AgentShow.jsp" />
	<%
	}
	%>
</body>
</html>