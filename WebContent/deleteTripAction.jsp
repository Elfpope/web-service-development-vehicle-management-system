<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="wsd.vms.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Action to mark vehicle deletion to the vehicle XML. If they have not been registered, authorisation error is returned -->
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

		int userId = user.getId();
		int tripId = Integer.parseInt(request.getParameter("tripId"));

		if (user.getEmail() != null) {
			vehiclesDao.deleteTrip(tripId, userId);
			response.sendRedirect(request.getHeader("referer"));
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	%>

</body>
</html>