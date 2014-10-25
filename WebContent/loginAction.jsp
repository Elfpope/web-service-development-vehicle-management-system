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
	<jsp:include page="pageTemplates/navigationBar.jsp" />
	<%
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String usersFilePath = application.getRealPath("WEB-INF/users.xml");
	%>

	<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication"
		scope="application">
		<jsp:setProperty name="vms" property="usersFilePath"
			value="<%=usersFilePath%>" />
	</jsp:useBean>

	<%
		User userLoggingIn = vms.getUser(user.getEmail(),
				user.getPassword());
		if (userLoggingIn != null) {
			user.setId(userLoggingIn.getId());
			user.setFirstName(userLoggingIn.getFirstName());
			user.setLastName(userLoggingIn.getLastName());
			user.setRole(userLoggingIn.getRole());
			response.sendRedirect(request.getHeader("referer"));
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
						<a href="javascript:history.back()" class="btn btn-warning">Return to the previous page</a>
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