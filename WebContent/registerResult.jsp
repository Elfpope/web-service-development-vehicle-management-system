<%@ page language="java" import="java.io.*,java.util.*, wsd.vms.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% VehicleManagementApplication vms = (VehicleManagementApplication) session.getAttribute("vms"); %>

<%
	String email = request.getParameter("email");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String password = request.getParameter("password");
	String role = "Driver";

	User user = new User(email, firstName, lastName, password, role);
	Users users = vms.getUsers();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Result Page</title>
</head>
<body>
	 
<% 
	if (user.getEmail() == null){
		String emailError = "Email is required";
	}
	if (user.getFirstName() == null){
		String firstNameError = "firstName is required";
	}
	if (user.getLastName() == null){
		String lastNameError = "firstName is required";
	}
	if (user.getPassword() == null){
		String passwordError = "Password is required";
	}

%>
<%-- 
<%
	if (agreeTOS != null && users.emailExists(user.getEmail()) == false) {
		users.addUser(user);
		diaryAppInit.marshallUser();
%>
<body bgcolor="<%= favColor %>" >
			<%= filePath%>	
	<p>Welcome, <%= user.getName() %>!</p>

	<p>Your Email is <%= user.getEmail() %>.</p>

	<p>Your password is <%= user.getPassword() %>.</p>

	<p>Your gender is <%= user.getGender() %>.</p>

	<p>Your favorite color is <%= user.getFavouriteColour() %>.</p>
	
	<p>Click <a href="index.jsp">here</a> to proceed to the main page.</p>
	
</body> 
	<%
		response.sendRedirect("index.jsp");
	%>

<%
	} else if (agreeTOS != null && users.emailExists(user.getEmail())) {
%>
	<p>Sorry, this email has been register.</p>
	<p>
		Click <a href="register.jsp">here</a> to go back.
	</p>
<%
	} else {
%>
	<p>Sorry, you must agree to the Terms of Services.</p>
	<p>
		Click <a href="register.jsp">here</a> to go back.
	</p>
<%
	}
	session.setAttribute("users", users);
%> --%>

<%
	users.addUser(user);
	vms.marshallUsers();
%>


</body>
</html>