<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="wsd.vms.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<c:import var="vehiclesXML" url="vehicles.xml" />
<c:import var="vehiclesXSLT" url="vehicles.xsl" />

<!-- Index home landing page of the application. Displays table of registered vehicles. 
Can add vehicles on this page if user is administrator -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle Management System</title>
</head>

<%
	//Initialize the web application with xml files path.
	String usersFilePath = application.getRealPath("WEB-INF/users.xml");
	String vehiclesFilePath = application.getRealPath("vehicles.xml");
	VehicleManagementApplication vms = (VehicleManagementApplication) session.getAttribute("vms");

	//Ensure only one VMS is created and reused accross the whole application
	if (vms == null) {
		vms = new VehicleManagementApplication(usersFilePath, vehiclesFilePath);
		session.setAttribute("vms", vms);
	}
%>

<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />

	<!-- JSP imports -->
	<jsp:include page="pageTemplates/navigationBar.jsp" />
	<jsp:include page="pageTemplates/addVehicleModal.jsp" />

	<!-- XML and XSLT -->
	<x:transform xml="${vehiclesXML}" xslt="${vehiclesXSLT}">
		<x:param name="currentlyLoggedIn" value='<%=user.getEmail() != null%>' />
		<x:param name="userRole" value='<%=user.getRole()%>' />
	</x:transform>
</body>
</html>