<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Popup form for adding a trip -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="bootstrap/css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript" src="bootstrap/js/moment.min.js"></script>
<script type="text/javascript"
	src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet"
	href="bootstrap/bootstrapvalidator-dist-0.5.2/css/bootstrapValidator.min.css" />
<script type="text/javascript"
	src="bootstrap/bootstrapvalidator-dist-0.5.2/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="bootstrap/bootstrapvalidator-dist-0.5.2/js/form.js"></script>

<style>
.nonReadOnly {
	cursor: auto !important;
	background-color: white !important;
}
</style>

</head>
<body>
	<div class="modal fade" id="addTripModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">x</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add a new trip</h4>
				</div>
				<form class="form-horizontal" action="addTripAction.jsp"
					method="post">
					<fieldset>
						<div class="modal-body">
							<div class="form-group">
								<label for="regoNumber" class="col-lg-3 control-label">
									Registration Number </label>
								<div class="col-lg-8">
									<input class="form-control" type="text" name="regoNumber"
										readonly value="<%=request.getParameter("regoNumber")%>" />
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="form-group">
								<label for="start" class="col-lg-3 control-label"> Start
									date </label>
								<div class='col-lg-8'>
									<input type='text' class="form-control nonReadOnly" id='start'
										data-date-format="DD/MM/YYYY HH:mm" name='start' readonly
										required />
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="form-group">
								<label for="end" class="col-lg-3 control-label"> End
									date </label>
								<div class='col-lg-8'>
									<input type='text' class="form-control nonReadOnly" id='end'
										data-date-format="DD/MM/YYYY HH:mm" name='end' readonly
										required />
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="form-group">
								<label for="description" class="col-lg-3 control-label">
									Description </label>
								<div class="col-lg-8">
									<textarea placeholder="Brief description of the trip"
										class="form-control" rows="3" name="description" required></textarea>
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="form-group">
								<label for="kilometres" class="col-lg-3 control-label">
									Kilometres travelled </label>
								<div class="col-lg-8">
									<input class="form-control" name="kilometres" required
										type="number" step="0.5">
								</div>
								<div class="col-lg-1"></div>
							</div>
							<div class="modal-footer">
								<div class="col-lg-10 col-lg-offset-2">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancel</button>
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>