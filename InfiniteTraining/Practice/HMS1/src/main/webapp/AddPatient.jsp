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

		<h:outputText value="Add Patient" />

	</h2>

	<h:form id="form">

		<h:outputText value="Patient Id " />

		<h:inputText id="id" value="#{patient.pid}" required="true"/>
		<br />

		<h:message for="form:id"></h:message>

		<br />
		<br />

		<h:outputText value="Patient Name " />

		<h:inputText id="name" value="#{patient.name}" />
		<br />

		<h:message for="form:name"></h:message>



		<br>
		<br>

		<h:outputText value="Patient Age " />

		<h:inputText id="age" value="#{patient.age}" required="true" />
		<br />

		<h:message for="form:age"></h:message>



		<br>
		<br>

		<h:outputText value="Patient Weight" />

		<h:inputText id="weight" value="#{patient.weight}" required="true" />
		<br />

		<h:message for="form:weight"></h:message>

		<br>
		<br>

		<h:outputText value=" Patient Gender " />

		<h:inputText id="gender" value="#{patient.gender}" />
		<br />

		<h:message for="form:gender"></h:message>

		<br />
		<br />

		<h:outputText value=" Patient Address " />

		<h:inputText id="address" value="#{patient.address}" />
		<br />

		<h:message for="form:address"></h:message>

		<br />
		<br />

		<h:outputText value=" Patient PhoneNo " />

		<h:inputText id="phno" value="#{patient.phoneno}" />
		
		<br />

		<h:message for="form:phno"></h:message>

		<br />
		<br />

		<h:outputText value=" Patient Disease " />

		<h:inputText id="disease" value="#{patient.disease}" />
		<br />

		<h:message for="form:disease"></h:message>

		<br />
		<br />

		<h:outputText value=" Patient DoctorId " />

		<h:inputText id="doctorId" value="#{patient.doctId}" />
		<br />

		<h:message for="form:doctorId"></h:message>

		<br />
		<br />
		<h:outputText value=" Patient Email " />

		<h:inputText id="email" value="#{patient.email}" />
		<br />

		<h:message for="form:email"></h:message>

		<br />
		<br />
		
		<h:commandButton action="#{patientDao.AddPatient(patient)}"
			value="Add Patient" />

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	<h:commandButton type="reset" value="Reset"></h:commandButton>



	</h:form>



</body>

	</html>



</f:view>