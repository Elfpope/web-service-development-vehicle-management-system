<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wsd.vms.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<c:import var="xml" url="vehicles.xml" />
<c:import var="xslt" url="vehicles.xsl" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<div class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Vehicle Management System</a>
		</div>
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<%
				if (user.getId() == null) {
			%>
			<form action="loginAction.jsp" class="navbar-form navbar-right"
				role="form" method="post">
				<div class="form-group">
					<input placeholder="ID" class="form-control" type="text" name="id">
				</div>
				<div class="form-group">
					<input placeholder="Password" class="form-control" type="password"
						name="password">
				</div>
				<button type="submit" class="btn btn-success">Sign in</button>
				<a href="register.jsp" class="btn btn-info">Register</a>
			</form>
			<%
				} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<div class="navbar-form">
					<a href="logout.jsp" class="btn btn-info">Log out</a>
				</div>
			</ul>
			<%
				}
			%>
		</div>
	</div>

	<ul class="breadcrumb">
		<li class="active">Home</li>
	</ul>

	<div class="jumbotron">
		<h1>Vehicle Management System</h1>
		<p>This is a vehicle management system, and this is the home page
			you're on atm.</p>
		<p></p>
	</div>

	<x:transform xml="${xml}" xslt="${xslt}" />

</body>
</html>