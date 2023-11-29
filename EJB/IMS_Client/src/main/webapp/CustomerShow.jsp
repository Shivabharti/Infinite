<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<f:view>
	<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h:form>
		<center>
			<h2>
				<h:outputText value="Customer Details" />
			</h2>
			<h:dataTable value="#{ejbImpl.showCustomer()}" var="c" border="3">
				<h:column>

					<f:facet name="header">
						<h:outputLabel value="Customer Id" />
					</f:facet>
					<h:outputText value="#{c.cust_ID}" />
				</h:column>

				<h:column>

					<f:facet name="header">
						<h:outputLabel value="First Name" />
					</f:facet>
					<h:outputText value="#{c.firstName}" />
				</h:column>

				<h:column>

					<f:facet name="header">
						<h:outputLabel value="last Name" />
					</f:facet>
					<h:outputText value="#{c.lastName}" />
				</h:column>

				<h:column>

					<f:facet name="header">
						<h:outputLabel value="Gender" />
					</f:facet>
					<h:outputText value="#{c.gender}" />
				</h:column>

				<h:column>

					<f:facet name="header">
						<h:outputLabel value="Date Of Birth" />
					</f:facet>
					<h:outputText value="#{c.dateOfBirth}" />

				</h:column>



				<h:column>

					<f:facet name="header">
						<h:outputLabel value="Status" />
					</f:facet>
					<h:outputText value="#{c.status}" />
				</h:column>

			</h:dataTable>

			<h:commandButton action="CustomerAdd.jsp?faces-redirect=true"
				value="Add Customer" />
		</center>
	</h:form>
</body>
	</html>
</f:view>