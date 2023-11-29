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
		<h2 style="text-align: center" class="col-sm-4">Add Your Record</h2>
		<hr />
Agent Id
                    <h:inputText id="empno" value="#{agent.agentId}" />
		<br />
Agent Name
                    <h:inputText id="name" value="#{agent.name}" />
		<br />
City
                	<h:inputText id="city" value="#{agent.city}" />
		<br />
Gender 
	<h:selectOneMenu value="#{agent.gender}">
			<f:selectItem itemValue="MALE" itemLabel="Male" />
			<f:selectItem itemValue="FEMALE" itemLabel="Female" />
		</h:selectOneMenu>

Marital Status 
                    <h:inputText id="maritalStatus" value="#{agent.maritalStatus}" />
		<br />
Premium
                    <h:inputText id="premium" value="#{agent.premium}" />
		<br />

		<h:commandButton value="Insert" action="#{ejbImpl.addAgentEjb(agent)}" />

	</h:form>
</body>
	</html>
</f:view>