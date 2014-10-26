<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="bootstrap/js/moment.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="bootstrap/bootstrapvalidator-dist-0.5.2/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="bootstrap/bootstrapvalidator-dist-0.5.2/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="bootstrap/bootstrapvalidator-dist-0.5.2/js/form.js"></script>

</head>
<body>
	<div class="modal fade" id="addVehicleModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">x</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Register new vehicle</h4>
				</div>
				<form class="form-horizontal" action="addVehicleAction.jsp"
					method="post">
					<fieldset>
						<div class="modal-body">
							<div class="form-group">
								<label for="regoNumber" class="col-lg-3 control-label">Registration Number</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="regoNumber" required>
								</div>
							</div>
							<div class="form-group">
								<label for="type" class="col-lg-3 control-label">Type</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="type" required>
								</div>
							</div>
							<div class="form-group">
								<label for="make" class="col-lg-3 control-label">Make</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="make" required>
								</div>
							</div>
							<div class="form-group">
								<label for="model" class="col-lg-3 control-label">Model</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="model" required>
								</div>
							</div>	
							<div class="form-group">
								<label for="colour" class="col-lg-3 control-label">Colour</label>
								<div class="col-lg-9">
									<input class="form-control" type="text" name="colour" required>
								</div>
							</div>					
							<div class="form-group">
								<label for="kilometres" class="col-lg-2 control-label">Kilometres
									travelled</label>
								<div class="col-lg-10">
									<input class="form-control bfh-number" name="kilometres" value = "0" required
									type="number" step="0.5" required>
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