<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wsd.vms.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle Management System</title>
</head>
<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />
	<jsp:include page="pageTemplates/navigationBar.jsp" />
	<%
		VehicleManagementApplication vms = (VehicleManagementApplication) session.getAttribute("vms");
		IVehiclesDao vehiclesDao = vms.getVehiclesDao();
		Vehicles vehilces = vehiclesDao.getVehicles();
	
		int userId = user.getId();
		int tripId = Integer.parseInt(request.getParameter("tripId"));
		
		//String vehiclesFilePath = application.getRealPath("vehicles.xml");
	%>
<%-- 	<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication"
		scope="application">
		<jsp:setProperty name="vms" property="vehiclesFilePath"
			value="<%=vehiclesFilePath%>" />
	</jsp:useBean> --%>

	<%
		if (user.getEmail() != null) {
			vehiclesDao.deleteTrip(tripId, userId);
			//vms.deleteTrip(tripId, userId);
			response.sendRedirect(request.getHeader("referer"));
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	%>

</body>
</html>