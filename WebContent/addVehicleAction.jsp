<%@ page language="java" import="java.io.*,java.util.*, wsd.vms.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Result Page</title>
</head>
<body>
<%
	VehicleManagementApplication vms = (VehicleManagementApplication) session.getAttribute("vms");
	IVehiclesDao vehiclesDao = vms.getVehiclesDao();
	Vehicles vehicles = vehiclesDao.getVehicles();
	
//	String vehiclesFilePath = application.getRealPath("vehicles.xml");
	
	String regoNumber = request.getParameter("regoNumber");
	String type = request.getParameter("type");
	double kilometres = Double.parseDouble(request.getParameter("kilometres"));
	String make = request.getParameter("make");
	String model = request.getParameter("model");
	String colour = request.getParameter("colour");
	String vehicleError = "";
	Vehicle vehicle;

%>

<%-- 	<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication"
		scope="application">
		<jsp:setProperty name="vms" property="vehiclesFilePath"
			value="<%=vehiclesFilePath%>" />
	</jsp:useBean>
 --%>
	<%

		//if all fields are valid, then create a new vehicle
		
		vehicle = new Vehicle( regoNumber,  type,kilometres,make,  model,colour);
			//only register the new user that is not in the registry
			
			if (!vehicles.vehicleExists(vehicle)) {
				vehiclesDao.addVehicle(vehicle);
/* 				vms.addVehicle(vehicle);
				vms.marshallVehicles(); */
				vehicleError = "YAYYYYYYYY";
			}
			else {
				vehicleError = "Vehicle already exists.";
			}
	%>

	<p> <%= vehicle.getRegoNumber() %> </p>
	<p> <%= vehicle.getType() %> </p>
	<p> <%= vehicle.getKilometres() %> </p>
	<p> <%= vehicle.getMake() %> </p>
	<p> <%= vehicle.getModel() %> </p>
	<p> <%= vehicle.getColour() %> </p>
    <p>Error: <%= vehicleError %> </p>
	<p>
		Click <a href="index.jsp">Home</a> to get to the home page.
	</p>


</body>
</html>