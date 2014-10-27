<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="wsd.vms.*"%>
<!-- Action to add trip to the vehicles XML. If they have not been registered, authorisation error is returned-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />

	<%
		VehicleManagementApplication vms = (VehicleManagementApplication) session
				.getAttribute("vms");
		IVehiclesDao vehiclesDao = vms.getVehiclesDao();
		Vehicles vehilces = vehiclesDao.getVehicles();

		Trip trip = new Trip();
		trip.setRegoNumber(request.getParameter("regoNumber"));
		trip.setStartDateTime(request.getParameter("start"));
		trip.setEndDateTime(request.getParameter("end"));
		trip.setDriverId(user.getId());
		trip.setDriverName(user.getFullName());
		trip.setDescription(request.getParameter("description"));
		trip.setKilometres(Double.parseDouble(request
				.getParameter("kilometres")));

		if (user.getEmail() != null) {
			vehiclesDao.addTrip(trip);
			response.sendRedirect(request.getHeader("referer"));
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	%>
</body>
</html>

