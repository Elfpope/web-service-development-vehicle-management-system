<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wsd.vms.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle Management System</title>
</head>
<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />
	<%
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String usersFilePath = application.getRealPath("WEB-INF/users.xml");
	%>
	<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication" scope="application">
		<jsp:setProperty name="vms" property="usersFilePath" value="<%=usersFilePath%>" />
	</jsp:useBean>

	<%
		User userLoggingIn = vms.getUser(user.getEmail(), user.getPassword());
		if (userLoggingIn != null) {
			user.setId(userLoggingIn.getId());
			user.setFirstName(userLoggingIn.getFirstName());
			user.setLastName(userLoggingIn.getLastName());
			user.setRole(userLoggingIn.getRole());
	%>
	
	<p>
		Logged in as
		<%=user.getEmail()%>
		<%=user.getPassword()%>
	</p>

	<a href="index.jsp">Return to home</a>
	
	<%
			} else { 
				user.setEmail(null);
				user.setPassword(null);
		%>
	
	<p>whoops! you should probably return home <a href="index.jsp">Return to home</a></p>
	
	<%} %>


</body>
</html>