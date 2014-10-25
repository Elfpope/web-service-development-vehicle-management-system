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
	String usersFilePath = application.getRealPath("WEB-INF/users.xml");

	int id = 100;
	String email = request.getParameter("email");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String password = request.getParameter("password");
	String confirmPassword = request.getParameter("confirmPassword");
	String role = "Driver";
	
	User user = null;
	String emailError = "";
	String firstNameError = "";
	String lastNameError = "";
	String passwordError = "";
	String confirmPasswordError = "";
	String passwordsMatchedError = "";
	String userError = "";
	boolean userInfoValided = false;

%>

	<jsp:useBean id="vms" class="wsd.vms.VehicleManagementApplication"
		scope="application">
		<jsp:setProperty name="vms" property="usersFilePath"
			value="<%=usersFilePath%>" />
	</jsp:useBean>

	<%
		//Valid user info fields, and generate error if invalid.
		if (!vms.isEmailValid(email)) {
			emailError = "Email is not valid";
		}
		if (!vms.isNameValid(firstName)) {
			firstNameError = "First name is not valid";
		}
		if (!vms.isNameValid(lastName)) {
			lastNameError = "Last name is not valid";
		}
		if (!vms.isPasswordValid(password)) {
			passwordError = "Password is not valid";
		}
		if (!vms.isPasswordValid(confirmPassword)) {
			confirmPasswordError = "Confirm password is not valid";
		}
		if (!vms.isconfirmPasswordSame(password, confirmPassword)) {
			passwordsMatchedError = "Passwords are not the same";
		}
		if (emailError.equals("") && firstNameError.equals("") && 
			lastNameError.equals("") && passwordError.equals("") && 
			confirmPasswordError.equals("") && passwordsMatchedError.equals("") ){
			userInfoValided = true;
		}
		
		//if all fields are valid, then create a new user
		if (userInfoValided == true)	{
			user = new User(id, email, firstName, lastName, password, role);
			
			//only register the new user that is not in the registry
			if (!vms.getUsers().userExists(user)) {
				vms.addUser(user);
				vms.marshallUsers();
			}
			else {
				userError = "User already exists.";
			}
		} 
	%>

	<p> <%= emailError %> </p>
	<p> <%= firstNameError %> </p>
	<p> <%= lastNameError %> </p>
	<p> <%= passwordError %> </p>
	<p> <%= confirmPasswordError %> </p>
	<p> <%= passwordsMatchedError %> </p>
	<p> All field valid ? <%= userInfoValided %> </p>
	<p> <%= userError %> </p>

	<p>
		Click <a href="index.jsp">Home</a> to get to the home page.
	</p>


</body>
</html>