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
	<h:inputText id="id" value="#{policy.cust_ID}" /><br/> 
	<h:message for="form:id"></h:message>
	<br/><br/>
	<h:outputText value="Insurance Id" />
	<h:inputText id="insuranceId" value="#{policy.insuranceId}" /><br/>
	<h:message for="form:insuranceId"></h:message>
	
		<br><br>
	<h:outputText value="Insurance Amount" />
	<h:inputText id="insuranceAmount" value="#{policy.insuranceAmount}" /><br/>
	<h:message for="form:insuranceAmount"></h:message>
	
	    <br><br>
	<h:selectOneMenu value="#{policy.payMode}">
	   	<f:selectItem itemValue="MONTHLY" itemLabel="MONTHLY" />
	   	<f:selectItem itemValue="QUARTERLY" itemLabel="QUARTERLY" />
	   	<f:selectItem itemValue="HALFYEARLY" itemLabel="HALFYEARLY" />
	   	<f:selectItem itemValue="YEARLY" itemLabel="YEARLY" />
	   	
	</h:selectOneMenu>

		<br><br>
	<h:outputText value="Register Date " />
	<h:inputText id="registerDate" value="#{policy.registerDate}">  
		<f:convertDateTime pattern="dd-MM-yyyy"/>  
	</h:inputText>
	<h:message for="form:registerDate"></h:message>
	<br/><br/>
	<h:commandButton action="#{ejbImpl.addCustomerPolicy(policy)}" value="Add Policy" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<h:commandButton type="reset" value="Reset"></h:commandButton>
	
	</h:form>

    </body>
</html>

</f:view>