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

		<center>

			<h2>
				<h:outputText value="Agent Records" />
			</h2>

		</center>

		<h:dataTable value="#{ejbImpl.showAgentEjb()}" var="a" border="3">

			<h:column>

				<f:facet name="header">

					<h:outputLabel value="Agent Id" />

				</f:facet>

				<h:outputText value="#{a.agentId}" />

			</h:column>

			<h:column>

				<f:facet name="header">

					<h:outputLabel value="Agent Name" />

				</f:facet>

				<h:outputText value="#{a.name}" />

			</h:column>

			<h:column>

				<f:facet name="header">

					<h:outputLabel value="Agent City" />

				</f:facet>

				<h:outputText value="#{a.city}" />

			</h:column>

			<h:column>

				<f:facet name="header">

					<h:outputLabel value="Gender" />

				</f:facet>

				<h:outputText value="#{a.gender}" />

			</h:column>

			<h:column>

				<f:facet name="header">

					<h:outputLabel value="Marital Status" />

				</f:facet>

				<h:outputText value="#{a.maritalStatus}" />

			</h:column>
			<h:column>

				<f:facet name="header">

					<h:outputLabel value="Premium" />

				</f:facet>

				<h:outputText value="#{a.premium}" />

			</h:column>

			<h:column>

				<f:facet name="header">

					<h:outputLabel value="Search" />

				</f:facet>

				<h:commandButton action="#{ejbImpl.searchAgentEjb(a.agentId) }"
					value="Search" />

			</h:column>
			<h:column>

				<f:facet name="header">

					<h:outputLabel value="Delete" />

				</f:facet>

				<h:commandButton action="#{ejbImpl.deleteAgentEjb(a.agentId) }"
					value="Delete" />

			</h:column>


		</h:dataTable>

		<center>
			<h:commandButton action="CreateAgent.jsp?faces-redirect=true"
				value="Add Agent" />
		</center>
	</h:form>

</body>

	</html>

</f:view>