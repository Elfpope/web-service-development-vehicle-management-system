<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="modal fade" id="registerUserModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">x</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Register new user</h4>
				</div>
				<form class="form-horizontal" action="addUserAction.jsp"
					method="post">
					<fieldset>
						<div class="modal-body">
							<div class="form-group">
								<label for="firstName" class="col-lg-3 control-label">First
									name</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="firstName" required>
								</div>
							</div>
							<div class="form-group">
								<label for="lastName" class="col-lg-3 control-label">Last
									name</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="lastName" required>
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-lg-3 control-label">Email</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="email" required>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-lg-3 control-label">Password</label>
								<div class="col-lg-9">
									<input class="form-control" type="password" name="password" required>
								</div>
							</div>							
							<div class="form-group">
								<label for="confirmPassword" class="col-lg-3 control-label">Confirm Password</label>
								<div class="col-lg-9">
									<input class="form-control" type="password" name="confirmPassword" required>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<div class="col-lg-10 col-lg-offset-2">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancel</button>
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>