<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style>
.noBorders {
	border: none !important;
}
</style>
</head>
<body>
	<h2 style="text-align: center" class="col-sm-4">Claim Request</h2>
	<hr />
	<h:form id="form">
		<h:panelGrid id="panel" columns="2" styleClass="noBorders">

			<h:outputLabel value="Claim Id" />
			<h:inputText id="claim_Id" value="#{req.claim_Id}"
				styleClass="noBorders">
				<f:convertNumber />
				<h:message for="form:claim_Id"></h:message>
			</h:inputText>

			<h:outputLabel value="Provider Id" />
			<h:inputText id="providerid" value="#{req.providerid}"
				styleClass="noBorders" />
			<h:message for="form:providerid"></h:message>


			<h:outputLabel value="Plan Id" />
			<h:inputText id="plan_id" value="#{req.plan_id}"
				styleClass="noBorders" />
			<h:message for="form:plan_id"></h:message>


			<h:outputLabel value="UHID" />
			<h:inputText id="uHID" value="#{req.uHID}" styleClass="noBorders" />
			<h:message for="form:uHID"></h:message>


			<h:outputLabel value="Admit Date" />
			<h:inputText id="admit_date" value="#{req.admit_date}"
				styleClass="noBorders">
				<f:convertDateTime pattern="yyyy/MM/dd" />

			</h:inputText>
			<h:message for="form:admit_date"></h:message>


			<h:outputLabel value="Discharge Date" />
			<h:inputText id="disc_date" value="#{req.disc_date}"
				styleClass="noBorders">
				<f:convertDateTime pattern="yyyy/MM/dd" />
			</h:inputText>
			<h:message for="form:disc_date"></h:message>


			<h:outputLabel value="Bill Amount" />
			<h:inputText id="bill_Amount" value="#{req.bill_Amount}"
				styleClass="noBorders" />
			<h:message for="form:bill_Amount"></h:message>


			<h:outputLabel value="Miscellaneous Amount" />
			<h:inputText id="mis_Amount" value="#{req.mis_Amount}"
				styleClass="noBorders" />
			<h:message for="form:mis_Amount"></h:message>


			<h:outputLabel value="Disease" />
			<h:inputText id="disease" value="#{req.disease}"
				styleClass="noBorders" />
			<h:message for="form:disease"></h:message>


			<h:outputLabel value="Comments" />
			<h:inputText id="comments" value="#{req.comments}"
				styleClass="noBorders" />
			<h:message for="form:comments"></h:message>


			<h:commandButton action="#{controller.addClaimHistoryController()}"
				value="Approve" />
			<h:commandButton action="ShowClaimHistory" value="Reject" />
		</h:panelGrid>
	</h:form>
</body>
	</html>
</f:view>