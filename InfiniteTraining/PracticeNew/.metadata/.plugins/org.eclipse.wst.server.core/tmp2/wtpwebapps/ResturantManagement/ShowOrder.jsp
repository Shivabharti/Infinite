<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
    <center>
    	<h2>
    		<h:outputLabel value="Order History"></h:outputLabel>
    	</h2>
	   <h:dataTable value="#{ordList}" var="e" border="5">
	        	            	    <h:column>
	        	           <f:facet name="header">
	        	           		<h:outputText value="Order Id" />
	        	           </f:facet>
	                    <h:outputText value="#{e.ordid}"/>
	                </h:column>
	                    <h:column>
	                     <f:facet name="header">
	        	           		<h:outputText value="Customer Id" />
	        	           </f:facet>
	                    <h:outputText value="#{e.cusid}"/>
	                </h:column>
	                    <h:column>
	                     <f:facet name="header">
	        	           		<h:outputText value="Vendor Id" />
	        	           </f:facet>
	                    <h:outputText value="#{e.venid}"/>
	                </h:column>
	                <h:column>
	                     <f:facet name="header">
	        	           		<h:outputText value="WalSources" />
	        	           </f:facet>
	                    <h:outputText value="#{e.walsource}"/>
	                </h:column>
	                 <h:column>
	                     <f:facet name="header">
	        	           		<h:outputText value="Menu Id" />
	        	           </f:facet>
	                    <h:outputText value="#{e.menid}"/>
	                </h:column>
	                <h:column>
	                     <f:facet name="header">
	        	           		<h:outputText value="Order Date" />
	        	           </f:facet>
	                    <h:outputText value="#{e.orddate}"/>
	                </h:column>
	                 <h:column>
	                     <f:facet name="header">
	        	           		<h:outputText value="Order Quantity" />
	        	           </f:facet>
	                    <h:outputText value="#{e.ordquantity}"/>
	                </h:column>
	                 <h:column>
	                     <f:facet name="header">
	        	           		<h:outputText value="Orederd BillAmount" />
	        	           </f:facet>
	                    <h:outputText value="#{e.ordbillamount}"/>
	                </h:column>
	                 <h:column>
	                     <f:facet name="header">
	        	           		<h:outputText value="Order Status" />
	        	           </f:facet>
	                    <h:outputText value="#{e.ordstatus}"/>
	                </h:column>
	                <h:column>
	                     <f:facet name="header">
	        	           		<h:outputText value="Order Comments" />
	        	           </f:facet>
	                    <h:outputText value="#{e.ordcomments}"/>
	                </h:column>                 
	        </h:dataTable>
        </center>
    </body>
</html>
</f:view>