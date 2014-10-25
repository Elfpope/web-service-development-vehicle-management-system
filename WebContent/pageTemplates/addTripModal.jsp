<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript" src="bootstrap/js/moment.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
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
				<form class="form-horizontal">
					<fieldset>
						<div class="modal-body">
							<div class="form-group">
								<label for="start" class="col-lg-2 control-label">Start</label>
								<div class='col-lg-4'>
									<input type='text' readonly="readonly" class="form-control" id='start' data-date-format="DD/MM/YYYY hh:mmA/PM"/>
								</div>
								<label for="end" class="col-lg-2 control-label">End</label>
								<div class='col-lg-4'>
									<input type='text' readonly="readonly" class="form-control" id='end' data-date-format="DD/MM/YYYY hh:mmA/PM"/>
								</div>
								<script type="text/javascript">
									$(function() {
										$('#start').datetimepicker({});
										$('#end').datetimepicker({});
										$("#start").on(	"dp.change", function(e) {
											$('#end').data("DateTimePicker").setMinDate(e.date);
											$('#end').data("DateTimePicker").setValue(e.date);
										});
										$("#end").on("dp.change", function(e) {
											$('#start').data("DateTimePicker").setMaxDate(e.date);
										});
									});
								</script>
							</div>
							<div class="form-group">
								<label for="description" class="col-lg-2 control-label">Description</label>
								<div class="col-lg-10">
									<span class="help-block">Brief description of trip
										purpose</span>
									<textarea class="form-control" rows="3" id="textArea"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="kilometres" class="col-lg-2 control-label">Kilometres travelled</label>
								<div class="col-lg-10">
									<input class="form-control bfh-number" id="kilometres">
								</div>
							</div>
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