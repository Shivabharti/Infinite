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



	<h2>

		<h:outputText value="Add Patient Reports" />

	</h2>

	<h:form id="form">

		<h:outputText value="Patient Id " />

		<h:inputText id="pid" value="#{patients.patient_Id}" />
		<br />

		<h:message for="form:pid"></h:message>



		<br>
		<br>

		<h:outputText value="Test Code " />

		<h:inputText id="testCode" value="#{patients.testCode}" required="true" />
		<br />

		<h:message for="form:testCode"></h:message>



		<br>
		<br>

		<h:outputText value="Test Name" />

		<h:inputText id="testName" value="#{patients.testName}" required="true" />
		<br />

		<h:message for="form:testName"></h:message>

		<br>
		<br>

		<h:outputText value=" Test Description " />

		<h:inputText id="testDescription" value="#{patients.testDescription}" />
		<br />

		<h:message for="form:testDescription"></h:message>

		<br />
		<br />

		<h:outputText value=" Cost " />

		<h:inputText id="cost" value="#{patients.cost}" />
		<br />

		<h:message for="form:cost"></h:message>

		<br />
		<br />

		<h:outputText value=" Comments " />

		<h:inputText id="comments" value="#{patients.comments}" />
		
		<br />

		<h:message for="form:comments"></h:message>

		<br />
		<br />
		
		<h:commandButton action="#{controller.addPatientReport(patients)}"
			value="Add Patient" />

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	<h:commandButton type="reset" value="Reset"></h:commandButton>



	</h:form>



</body>

	</html>



</f:view>