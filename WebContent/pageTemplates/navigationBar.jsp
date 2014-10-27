<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="wsd.vms.*"%>
<!-- Navigation bar used throughout the site -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
<link href="bootstrap/sandstone/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:useBean id="user" class="wsd.vms.User" scope="session" />
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Vehicle Management
				System</a>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<%
				if (user.getEmail() == null) {
			%>
			<form action="loginAction.jsp" class="navbar-form navbar-right"
				role="form" method="post">
				<div class="form-group">
					<input placeholder="Email" class="form-control" type="text"
						name="email">
				</div>
				<div class="form-group">
					<input placeholder="Password" class="form-control" type="password"
						name="password">
				</div>
				<button type="submit" class="btn btn-success">Sign in</button>
				<a href="#" type="button" class="btn btn-info" data-toggle="modal"
					data-target="#addUserModal"> Register </a>
			</form>
			<%
				} else {
			%>
			<form class="navbar-form navbar-right">
				<a>Currently logged in as <%=user.getFirstName()%> <%=user.getLastName()%>
					<%
						if (user.isAdministrator()) {
					%> [ADMINISTRATOR] <%
						}
					%>
				</a> <a href="logout.jsp" type="button" class="btn btn-info">Logout</a>
			</form>
			<%
				}
			%>
		</div>
	</div>
	<jsp:include page="addUserModal.jsp" />
</body>
</html>