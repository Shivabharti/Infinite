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
	<h:outputText value="Add Customer" />
	</h2>
	<h:form id="form">
	<h:outputText value="Customer Id " />
	<h:inputText id="id" value="#{customer.cust_ID}" /><br/> 
	<h:message for="form:id"></h:message>
	<br/><br/>
	<h:outputText value="First Name " />
	<h:inputText id="firstName" value="#{customer.firstName}" /><br/>
	<h:message for="form:firstName"></h:message>
	
		<br><br>
	<h:outputText value="Last Name " />
	<h:inputText id="lastName" value="#{customer.lastName}" /><br/>
	<h:message for="form:lastName"></h:message>
	
	    <br><br>
	<h:outputText value="Customer Gender" />
	<h:inputText id="Gender" value="#{customer.gender}" /><br/>
	<h:message for="form:Gender"></h:message>
		<br><br>
	<h:outputText value="Customer DateOfBirth " />
	<h:inputText id="dateOfbirth" value="#{customer.dateOfBirth}">  
		<f:convertDateTime pattern="dd-MM-yyyy"/>  
	</h:inputText>
	<h:message for="form:dateOfbirth"></h:message>
	<br/><br/>
	<h:outputText value="Customer UserName" />
	<h:inputText id="userName" value="#{customer.userName}" /><br/>
	<h:message for="form:userName"></h:message>
	<br/><br/>
	<h:outputText value=" Customer PassWord " />
	<h:inputText id="pass" value="#{customer.passCode}" /><br/>
	<h:message for="form:pass"></h:message>
	<br/><br/>
	<h:outputText value="Customer Email" />
	<h:inputText id="email" value="#{customer.email}" /><br/>
	<h:message for="form:email"></h:message>
	<br/><br/>
	<h:outputText value="Customer Status" />
	<h:inputText id="status" value="#{customer.status}" /><br/>
	<h:message for="form:status"></h:message>
	<br/><br/>
	<h:commandButton action="#{ejbImpl.addCustomer(customer)}" value="Add Customer" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<h:commandButton type="reset" value="Reset"></h:commandButton>
	
	</h:form>

    </body>
</html>

</f:view>