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
	<form method="get" action="AddAgent.jsp">
		<center>
			Agent Id: <input type="number" name="agentId" /><br /> <br />
			Agent Name: <input type="text" name="name" /><br /> <br /> City: <input
				type="text" name="city" /><br /> <br /> 
				Gender: <select name="gender">
				<option value="MALE">Male</option>
				<Option value="FEMALE">Female</Option>
				</select>
				<br />
				<br /> 
				MaritalStatus :
				<select name="maritalStatus">
					<option value="0">0</option>
					<option value="1">1</option>
			</select>
				<br />
				<br /> Premium :
				<input type="number" name="premium" />
				<br />
				<br />
				<input type="submit" value="Add Agent" />
		</center>
	</form>
	<%
	if (request.getParameter("agentId") != null && request.getParameter("premium") != null) {
		AgentDAO dao = new AgentDAOImpl();
		Agent agent = new Agent();
		agent.setAgentId(Integer.parseInt(request.getParameter("agentId")));
		agent.setName(request.getParameter("name"));
		agent.setCity(request.getParameter("city"));
		agent.setGender(Gender.valueOf(request.getParameter("gender")));
		agent.setMaritalStatus(Integer.parseInt(request.getParameter("maritalStatus")));
		agent.setPremium(Double.parseDouble(request.getParameter("premium")));
		dao.addAgentDao(agent);
	%>
	<jsp:forward page="AgentShow.jsp" />
	<%
	}
	%>
</body>
</html>