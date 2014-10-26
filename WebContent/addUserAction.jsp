<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 import="java.io.*,java.util.*, wsd.vms.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User registration</title>
</head>
<body>
	<jsp:include page="pageTemplates/navigationBar.jsp" />

	<%
		VehicleManagementApplication vms = (VehicleManagementApplication) session.getAttribute("vms");
		IUsersDao usersDao = vms.getUsersDao();
		Users users = usersDao.getUsers();
		
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setPassword(request.getParameter("password"));
		user.setRole("Driver");

		if (!users.userExists(user)) {
			usersDao.addUser(user);
	%>
	
	<div class="container" style="margin-top: 75px;">
		<div class="row vertical-center-row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">Successfully registered</h3>
					</div>
					<div class="panel-body">You have now been registered. You can now login.</div>
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
						<h3 class="panel-title">Registration failed</h3>
					</div>
					<div class="panel-body">
						The email <%=request.getParameter("email")%> has already been registered.
						Please try registering with a different email.
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