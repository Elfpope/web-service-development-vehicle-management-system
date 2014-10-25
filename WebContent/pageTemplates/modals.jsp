<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="modal fade" id=NOTWORKING tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Delete Trip</h4>
				</div>
				<div class="modal-body">
				Are you sure you wish to delete this trip?
				<%= request.getParameter("tripId") %> HELLO?? <%= request.getParameter("regoNumber") %></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<a href="deleteTripAction.jsp?tripId=7" type="button"
						class="btn btn-primary">Yes</a>
				</div>
			</div>
		</div>
	</div>

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
				<form class="form-horizontal">
					<fieldset>
						<div class="modal-body">
							<div class="form-group">
								<label for="textArea" class="col-lg-2 control-label">Description</label>
								<div class="col-lg-10">
									<span class="help-block">Brief description of trip purpose</span>
									<textarea class="form-control" rows="3" id="textArea"></textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<div class="col-lg-10 col-lg-offset-2">
								<button class="btn btn-default">Cancel</button>
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="registerUserModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">x</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">ALO?</h4>
				</div>
				<form class="form-horizontal">
					<fieldset>
						<div class="modal-body">
							<div class="form-group">
								<label for="textArea" class="col-lg-2 control-label">Description</label>
								<div class="col-lg-10">
									<span class="help-block">Brief description of trip purpose</span>
									<textarea class="form-control" rows="3" id="textArea"></textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<div class="col-lg-10 col-lg-offset-2">
								<button class="btn btn-default">Cancel</button>
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