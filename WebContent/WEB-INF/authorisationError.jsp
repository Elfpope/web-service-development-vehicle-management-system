<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorisation Error</title>
</head>
<body>
	<jsp:include page="../pageTemplates/navigationBar.jsp" />
	<div class="container" style="margin-top: 75px;">
		<div class="row vertical-center-row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">Unauthorised access</h3>
					</div>
					<div class="panel-body">
						<p>Whoops! Looks like you don't have access to this page.</p>
					</div>
					<div class="panel-footer text-center">
						<a href="index.jsp" class="btn btn-warning">Return	to home page</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>
</body>
</html>