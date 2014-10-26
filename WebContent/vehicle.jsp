<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" import="wsd.vms.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<c:import var="vehiclesXML" url="vehicles.xml" />
<c:import var="vehicleAndTripsXSLT" url="vehicleAndTrips.xsl" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle Information <%=request.getParameter("regoNumber")%></title>
</head>

<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />
	<jsp:include page="pageTemplates/navigationBar.jsp" />
	<jsp:include page="pageTemplates/addTripModal.jsp" />

	<x:transform xml="${vehiclesXML}" xslt="${vehicleAndTripsXSLT}">
		<x:param name="regoNumberFilter"
			value='<%=request.getParameter("regoNumber")%>' />
		<x:param name="currentlyLoggedIn" value='<%=user.getEmail() != null%>' />
	</x:transform>
</body>
</html>