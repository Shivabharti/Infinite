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
	<h:outputText value="Login" />
	</h2>
	<h:form id="form">
	<h:outputText value="Customer UserName " />
	<h:inputText id="id" value="#{customer.userName}" /><br/> 
	<h:message for="form:id"></h:message>
	<br/><br/>	
	<h:outputText value="Customer PassWord" />
	<h:inputText id="passCode" value="#{customer.passCode}" /><br/>
	<h:message for="form:passCode"></h:message>
	<br/><br/>
	
	<h:commandButton action="#{ejbImpl.LoginCustomer(customer)}" value="Login" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<h:commandButton type="reset" value="Reset"></h:commandButton>
	
	</h:form>

    </body>
</html>

</f:view>