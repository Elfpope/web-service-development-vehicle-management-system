<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="modal fade" id="deleteTripModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">x</span> <span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Delete Trip</h4>
				</div>
				<div class="modal-body">Are you sure you wish to delete this
					trip?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<a href="deleteTripAction.jsp?tripId=7" type="button" class="btn btn-primary">Yes</a>
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
					<h4 class="modal-title" id="myModalLabel">Add New Trip</h4>
				</div>
				<form class="form-horizontal">
					<fieldset>
						<div class="modal-body">
							<div class="form-group">
								<label for="textArea" class="col-lg-2 control-label">Description</label>
								<div class="col-lg-10">
									<span class="help-block">A longer block of help text
										that breaks onto a new line and may extend beyond one line.</span>
									<textarea class="form-control" rows="3" id="textArea"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">Radios</label>
								<div class="col-lg-10">
									<div class="radio">
										<label> <input name="optionsRadios"
											id="optionsRadios1" value="option1" checked="" type="radio">
											Option one is this
										</label>
									</div>
									<div class="radio">
										<label> <input name="optionsRadios"
											id="optionsRadios2" value="option2" type="radio">
											Option two can be something else
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="select" class="col-lg-2 control-label">Selects</label>
								<div class="col-lg-10">
									<select class="form-control" id="select">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select> <br> <select multiple="" class="form-control">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
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