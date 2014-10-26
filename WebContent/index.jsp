<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wsd.vms.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<c:import var="vehiclesXML" url="vehicles.xml" />
<c:import var="vehiclesXSLT" url="vehicles.xsl" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle Management System</title>
</head>

<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />
	<jsp:include page="pageTemplates/navigationBar.jsp" />
	<jsp:include page="pageTemplates/addVehicleModal.jsp" />
	<x:transform xml="${vehiclesXML}" xslt="${vehiclesXSLT}" >
		<x:param name="currentlyLoggedIn" value='<%=user.getEmail() != null%>' />
		<x:param name="userRole" value='<%=user.getRole()%>' />
	</x:transform>
	
	
</body>
</html>