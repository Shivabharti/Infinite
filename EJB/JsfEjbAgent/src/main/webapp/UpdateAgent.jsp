<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h:form>
		<h2 style="text-align: center" class="col-sm-4">Edit Your Record</h2>
		<hr />
Agent Id
                    <h:inputText id="agentId" value="#{editAgent.agentId}" />
		<br />
Agent Name
                    <h:inputText id="name" value="#{editAgent.name}" />
		<br />
City 
                    <h:inputText id="city" value="#{editAgent.city}" />
		<br />                    
Gender 
                    <h:inputText id="gender" value="#{editAgent.gender}" />
		<br />
MaritalStatus
                    <h:inputText id="maritalStatus"
			value="#{editAgent.maritalStatus}" />
		<br />
Premium
                    <h:inputText id="premium"
			value="#{editAgent.premium}" />
		<br />
		<h:commandButton value="Update"
			action="#{ejbImpl.updateAgentEjb(editAgent)}" />

	</h:form>
</body>
	</html>
</f:view>