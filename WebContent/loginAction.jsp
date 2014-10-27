<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wsd.vms.*"%>
<!-- Action to log user into the system. If user could not be found, error is displayed-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />
	<jsp:include page="pageTemplates/navigationBar.jsp" />
	<%
		VehicleManagementApplication vms = (VehicleManagementApplication) session
				.getAttribute("vms");

		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		User userLoggingIn = vms.getUsersDao().getUser(user.getEmail(),
				user.getPassword());

		if (userLoggingIn != null) {
			user.setId(userLoggingIn.getId());
			user.setFirstName(userLoggingIn.getFirstName());
			user.setLastName(userLoggingIn.getLastName());
			user.setRole(userLoggingIn.getRole());

			response.sendRedirect("index.jsp");

		} else {
			user.setEmail(null);
			user.setPassword(null);
	%>

	<div class="container" style="margin-top: 75px;">
		<div class="row vertical-center-row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">Login Failed</h3>
					</div>
					<div class="panel-body">Failed to login. Please try again.</div>
					<div class="panel-footer text-center">
						<a href="index.jsp" class="btn btn-warning">Return to home
							page</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>