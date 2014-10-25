<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wsd.vms.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<c:import var="vehiclesXML" url="vehicles.xml" />
<c:import var="vehiclesXSLT" url="vehicles.xsl" />

<% String usersFilePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication" scope="application">
	<jsp:setProperty name="vms" property="usersFilePath" value="<%= usersFilePath%>" />
</jsp:useBean>
<% session.setAttribute("vms", vms); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle Management System</title>
</head>

<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />
	<jsp:include page="pageTemplates/navigationBar.jsp" />

	<x:transform xml="${vehiclesXML}" xslt="${vehiclesXSLT}" />

</body>
</html>