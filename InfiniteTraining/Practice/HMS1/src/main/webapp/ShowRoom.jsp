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
                <h2><h:outputText value="Room Details"/></h2>
            </center>
        <center>
        <h:dataTable value="#{roomDao.showRoomDao()}" var="r" border="5">
        	            	    <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Room No" />
        	           </f:facet>
                    <h:outputText value="#{r.room_no}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
        	           		<h:outputText value="Room Type" />
        	           </f:facet>
                    <h:outputText value="#{r.room_type}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
        	           		<h:outputText value="Status" />
        	           </f:facet>
                    <h:outputText value="#{r.status}"/>
                </h:column>
        </h:dataTable>
        </h:form>
        </center>
    </body>
</html>
</f:view>