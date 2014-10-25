<%@ page language="java" import="java.io.*,java.util.*, wsd.vms.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Result Page</title>
</head>
<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />

	<%
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setRole("Driver");

		String usersFilePath = application.getRealPath("WEB-INF/users.xml");
	%>

	<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication"
		scope="application">
		<jsp:setProperty name="vms" property="usersFilePath"
			value="<%=usersFilePath%>" />
	</jsp:useBean>
	<%
		if (vms.getUser(user.getEmail(), user.getPassword()) == null) {
			vms.addUser(user);
		}
	%>

	<%
		if (user.getEmail() == null) {
			String emailError = "Email is required";
		}
		if (user.getFirstName() == null) {
			String firstNameError = "firstName is required";
		}
		if (user.getLastName() == null) {
			String lastNameError = "lastName is required";
		}
		if (user.getPassword() == null) {
			String passwordError = "Password is required";
		}
	%>

</body>
</html>