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
        <h:form>
			<center>
				<h2><h:outputText value="Welcome TO DashBoard"></h:outputText></h2>
				<h:outputText value="#{userName}"/> <br/><br/>
				
			</center>
			<h:commandLink action="CustomerShow" id="link1">
        	<h:outputLabel value="Show Customer " />
        </h:commandLink> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<h:commandLink id="link2" action="InsuranceShow">
				<h:outputText value="Show Insurance"></h:outputText>
			</h:commandLink> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<h:commandLink id="link3" action="ShowCustomerPolicy">
				<h:outputText value="ShowCustomerPolicy"></h:outputText>
			</h:commandLink>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<h:commandLink id="link4" action="ResetPassWord">
				<h:outputText value="Reset PassWord"></h:outputText>
			</h:commandLink>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
		</h:form>
    </body>
</html>
</f:view>