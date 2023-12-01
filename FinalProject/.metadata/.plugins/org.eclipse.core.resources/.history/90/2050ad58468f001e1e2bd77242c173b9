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
		<h:dataTable value="#{requestlist}" var="e" border="3">

			<h:column>
				<f:facet name="header">
					<h:outputLabel value="claim_Id" />
				</f:facet>
				<h:outputText value="#{e.claim_Id}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="uhId" />
				</f:facet>
				<h:outputText value="#{e.uHID}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="fName" />
				</f:facet>
				<h:outputText value="#{e.firstName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="dob" />
				</f:facet>
				<h:outputText value="#{e.dob.toString().substring(0, 10)}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="providerid" />
				</f:facet>
				<h:outputText value="#{e.providerid}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="subscription_Id" />
				</f:facet>
				<h:outputText value="#{e.subscription_Id}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="admit_date" />
				</f:facet>
				<h:outputText value="#{e.admit_date.toString().substring(0, 10)}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="disc_date" />
				</f:facet>
				<h:outputText value="#{e.disc_date.toString().substring(0, 10)}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="bill_Amount" />
				</f:facet>
				<h:outputText value="#{e.bill_Amount}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="mis_Amount" />
				</f:facet>
				<h:outputText value="#{e.mis_Amount}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="disease" />
				</f:facet>
				<h:outputText value="#{e.disease}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="comments" />
				</f:facet>
				<h:outputText value="#{e.comments}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Validate" />
				</f:facet>
				<h:commandButton action="ClaimReqByProId.jsp"
					value="Validate" />
			</h:column>

		</h:dataTable>
	</h:form>
</body>
	</html>
</f:view>