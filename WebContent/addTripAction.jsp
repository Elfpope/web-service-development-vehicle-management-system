<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wsd.vms.User"%>
<%@ page import="wsd.vms.Trip"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />

	<%
		Trip trip = new Trip();
			trip.setRegoNumber(request.getParameter("regoNumber"));
			trip.setDriverId(user.getId());
			trip.setDriverName(user.getFullName());
			trip.setStartDate(request.getParameter("start"));
			trip.setStartTime(request.getParameter("start"));
			trip.setEndDate(request.getParameter("end"));
			trip.setEndTime(request.getParameter("end"));
			trip.setDescription(request.getParameter("description"));
			trip.setKilometres(Double.parseDouble(request.getParameter("kilometres")));

		System.out.println(request.getParameter("regoNumber"));
		System.out.println(request.getParameter("start"));
		System.out.println(request.getParameter("end"));
		System.out.println(request.getParameter("description"));

		String vehiclesFilePath = application.getRealPath("vehicles.xml");
	%>

	<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication"
		scope="application">
		<jsp:setProperty name="vms" property="vehiclesFilePath"
			value="<%=vehiclesFilePath%>" />
	</jsp:useBean>

	<%
		if (user.getEmail() != null) {
			vms.addTrip(trip);
			response.sendRedirect(request.getHeader("referer"));
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	%>
</body>
</html>

