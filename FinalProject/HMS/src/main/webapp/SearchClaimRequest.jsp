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

	
		<h2>Search claim request by claim id</h2>
		<h:form id="form">
			<!-- Email input field -->
			<h:outputLabel for="did">Claim Id</h:outputLabel>
			<h:inputText id="did" value="#{insClaim.claim_Id}"
				required="true" >
				<f:convertNumber/>
				</h:inputText>
			<br />
			<br />
			<!-- Generate OTP button -->
			<h:commandButton
				action="#{hmsImpl.showInsuranceRequest(insClaim.claim_Id)}"
				value="Search" />
			<br />
			<br />
		</h:form>


</body>
	</html>
</f:view>