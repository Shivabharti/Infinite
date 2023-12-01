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
	<h2 style="text-align: center" class="col-sm-4">Show Details Prov</h2>
	<hr />
	<h:form id="form">
		

			<h:outputLabel value="Claim Id" />
			<h:inputText id="claim_Id" value="#{ins.claim_Id}"
				styleClass="noBorders">
				<f:convertNumber />
			</h:inputText>
				<h:message for="form:claim_Id"></h:message>
			<br />



			<h:outputLabel value="Name" />
			<h:inputText id="pName" value="#{ins.firstName}"
				styleClass="noBorders">
			</h:inputText>
				<h:message for="form:pName"></h:message>
			<br />


			<h:outputLabel value="dOB" />
			<h:inputText id="dOB" value="#{ins.dob}" styleClass="noBorders">
			<f:convertDateTime pattern="yyyy/MM/dd" />
			</h:inputText>
				<h:message for="form:dOB"></h:message>
			<br />

			<h:outputLabel value="Provider Id" />
			<h:inputText id="providerid" value="#{ins.providerid}"
				styleClass="noBorders" />
			<h:message for="form:providerid"></h:message>
			<br />
			
			<h:outputLabel value="Subs Id" />
			<h:inputText id="subsId" value="#{ins.subscription_Id}"
				styleClass="noBorders" />
			<h:message for="form:subsId"></h:message>
			<br />

			<h:outputLabel value="UHID" />
			<h:inputText id="uHID" value="#{ins.uHID}" styleClass="noBorders" />
			<h:message for="form:uHID"></h:message>
			<br />

			<h:outputLabel value="Admit Date" />
			<h:inputText id="admit_date" value="#{ins.admit_date}"
				styleClass="noBorders">
				<f:convertDateTime pattern="yyyy/MM/dd" />
			</h:inputText>
			<h:message for="form:admit_date"></h:message>
			<br />


			<h:outputLabel value="Discharge Date" />
			<h:inputText id="disc_date" value="#{ins.disc_date}"
				styleClass="noBorders">
				<f:convertDateTime pattern="yyyy/MM/dd" />
			</h:inputText>
			<h:message for="form:disc_date"></h:message>
			<br />

			<h:outputLabel value="Bill Amount" />
			<h:inputText id="bill_Amount" value="#{ins.bill_Amount}"
				styleClass="noBorders" />
			<h:message for="form:bill_Amount"></h:message>
			<br />

			<h:outputLabel value="Miscellaneous Amount" />
			<h:inputText id="mis_Amount" value="#{ins.mis_Amount}"
				styleClass="noBorders" />
			<h:message for="form:mis_Amount"></h:message>
			<br />


			<h:outputLabel value="Disease" />
			<h:inputText id="disease" value="#{ins.disease}"
				styleClass="noBorders" />
			<h:message for="form:disease"></h:message>
			<br />

			<h:outputLabel value="Comments" />
			<h:inputText id="comments" value="#{ins.comments}"
				styleClass="noBorders" />
			<h:message for="form:comments"></h:message>
			<br />

			<h:commandButton action="#{controller.addClaimHistoryControl()}"
				value="Validate" />
			<h:commandButton action="#{hmsImpl.sendRejectMsg(ins)}"
				value="Reject" />
	</h:form>
</body>
	</html>
</f:view>