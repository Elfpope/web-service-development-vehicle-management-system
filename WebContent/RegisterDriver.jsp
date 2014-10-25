<%@ page language="java" import="wsd.vms.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Driver Page</title>
</head>

<body>

	<h1>Register a driver</h1>

	<form name="input" action="registerResult.jsp" method="post">
		<table style="width: 300px">
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>

			<tr>
				<td>First name</td>
				<td><input type="text" name="firstName"></td>
			</tr>

			<tr>
				<td>Last name</td>
				<td><input type="text" name="lastName"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>

		</table>
		<input type="submit" value="Register">
	</form>

</body>
</html>