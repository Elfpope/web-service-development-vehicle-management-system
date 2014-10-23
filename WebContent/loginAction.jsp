<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wsd.vms.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle Management System</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/simplex-css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="bootstrap/simplex-css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<!--  <link href="bootstrap/css/theme.css" rel="stylesheet">-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css" id="holderjs-style"></style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="../../assets/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</head>
<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />
	<%
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		String usersFilePath = application.getRealPath("WEB-INF/users.xml");
	%>
	<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication" scope="application">
		<jsp:setProperty name="vms" property="usersFilePath" value="<%=usersFilePath%>" />
	</jsp:useBean>

	<%
		User userLoggingIn = vms.getUser(user.getId(), user.getPassword());
		if (userLoggingIn != null) {
			user.setFirstName(userLoggingIn.getFirstName());
			user.setLastName(userLoggingIn.getLastName());
			user.setRole(userLoggingIn.getRole());
	%>
	
	<p>
		Logged in as
		<%=user.getId()%>
		<%=user.getPassword()%>
	</p>

	<a href="index.jsp">Return to home</a>
	
	<% } else { 
		user.setId(null);
		user.setPassword(null);
	%>
	
	<p>whoops! you should probably return home <a href="index.jsp">Return to home</a></p>
	
	<%} %>


</body>
</html>