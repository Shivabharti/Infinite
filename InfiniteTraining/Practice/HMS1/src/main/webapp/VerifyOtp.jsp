<%@page contentType="text/html"%>

<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>OTP verification</h2>
<h:form id="form">
<h:outputText value="Patient Name" />
<br/>
<h:inputText id="name" value="#{patient.name}" />
<br/><br/>

<h:outputText value="Otp" />
<br/>
<h:inputText id="otp" value="#{patient.otp}" />
<br/>
<h:commandButton action="#{patientDao.otpVerification(patient)}" value="Add Patient" />
<h:commandButton action="reset" value="Reset" />
</h:form>

</body>
	</html>
	</f:view>