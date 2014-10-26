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
		IUsersDao usersDao = vms.getUsersDao();
		Users users = usersDao.getUsers();

		int id = 0;
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String role = "Driver";
		User user = new User(id, email, firstName, lastName, password, role);

		//String usersFilePath = application.getRealPath("WEB-INF/users.xml");
	%>


	<%-- 	<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication"
		scope="application">
		<jsp:setProperty name="vms" property="usersFilePath"
			value="<%=usersFilePath%>" />
	</jsp:useBean> --%>

	<%

		//only register the new user that is not in the registry
		if (!users.userExists(user)) {
			usersDao.addUser(user);
/* 			vms.addUser(user);
			vms.marshallUsers(); */
		} else {
	%>
	<div class="container" style="margin-top: 75px;">
		<div class="row vertical-center-row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">Register Failed</h3>
					</div>
					<div class="panel-body">Failed to register. Please try again.</div>
					<div class="panel-footer text-center">
						<a href="javascript:history.back()" class="btn btn-warning">Return
							to the previous page</a>
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