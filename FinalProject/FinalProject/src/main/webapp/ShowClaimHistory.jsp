<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h:form>
		<center>
			<h2>
				<h:outputText value="Employ Records" />
			</h2>
		</center>
		<h:dataTable value="#{hmsImpl.showClaimHistory()}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="claimHistoryId" />
				</f:facet>
				<h:outputText value="#{e.claimHistoryId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="claim_Id" />
				</f:facet>
				<h:outputText value="#{e.claim_Id}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="providerId" />
				</f:facet>
				<h:outputText value="#{e.providerId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="subscription_Id" />
				</f:facet>
				<h:outputText value="#{e.subscription_Id}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="uhId" />
				</f:facet>
				<h:outputText value="#{e.uhId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="fromDate" />
				</f:facet>
				<h:outputText value="#{e.fromDate}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="toDate" />
				</f:facet>
				<h:outputText value="#{e.toDate}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="reimbursementAmount" />
				</f:facet>
				<h:outputText value="#{e.reimbursementAmount}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="patientResponsibility" />
				</f:facet>
				<h:outputText value="#{e.patientResponsibility}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="status" />
				</f:facet>
				<h:outputText value="#{e.status}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="comments" />
				</f:facet>
				<h:outputText value="#{e.comments}" />
			</h:column>
		</h:dataTable>
		</h:form>
</body>
	</html>
</f:view>