<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" import="wsd.vms.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Vehicle</title>
</head>
<body>
	<jsp:include page="pageTemplates/navigationBar.jsp" />

	<%
		VehicleManagementApplication vms = (VehicleManagementApplication) session.getAttribute("vms");
		IVehiclesDao vehiclesDao = vms.getVehiclesDao();
		Vehicles vehicles = vehiclesDao.getVehicles();
		
		Vehicle vehicle = new Vehicle();
		vehicle.setRegoNumber(request.getParameter("regoNumber"));
		vehicle.setType(request.getParameter("type"));
		vehicle.setMake(request.getParameter("make"));
		vehicle.setModel(request.getParameter("model"));
		vehicle.setColour(request.getParameter("colour"));
		vehicle.setKilometres(Double.parseDouble(request.getParameter("kilometres")));

		if (!vehicles.vehicleExists(vehicle)) {
			vehiclesDao.addVehicle(vehicle);
	%>
	
	<div class="container" style="margin-top: 75px;">
		<div class="row vertical-center-row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">Successfully added vehicle</h3>
					</div>
					<div class="panel-body">
						Vehicle <%= vehicle.getRegoNumber() %> has now been added
					</div>
					<div class="panel-footer text-center">
						<a href="<%= request.getHeader("referer") %>" class="btn btn-info">Return
							to the previous page</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>
	
	<%
		} else {
	%>
	
	<div class="container" style="margin-top: 75px;">
		<div class="row vertical-center-row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">Add new vehicle failed</h3>
					</div>
					<div class="panel-body">
						The vehicle <%=request.getParameter("regoNumber")%> already exists.
						Please try registering with a different vehicle.
					</div>
					<div class="panel-footer text-center">
						<a href="<%= request.getHeader("referer") %>"
							class="btn btn-warning">Return to the previous page</a>
					</div>
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>
	
	<%
		}
	%>

</body>
</html>