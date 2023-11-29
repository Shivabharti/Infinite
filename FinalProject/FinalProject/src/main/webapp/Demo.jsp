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

	<jsp:include page="ShowInsuranceClaim.jsp"/>
		<h2>Search claim request</h2>
		<h:form id="form">
			<!-- Email input field -->
			<h:selectOneMenu value="#{insClaim.type}">
			   	<f:selectItem itemValue="ClaimId" itemLabel="ClaimId" />
			   	<f:selectItem itemValue="ProviderId" itemLabel="ProviderId" />
			</h:selectOneMenu>								
			<!-- Generate OTP button -->
			<h:inputText value="#{insClaim.claim_Id}" />
			<h:inputText value="#{insClaim.providerid}" />
			<h:commandButton
				action="#{hmsImpl.oneSearchButton(insClaim)}"
				value="Search" />
				<br/>				
			
		</h:form>
		


</body>
	</html>
</f:view>