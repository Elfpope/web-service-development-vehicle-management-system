$(function() {
    $('.form-horizontal').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email is required and cannot be empty'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            },
            username: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and cannot be empty'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'The username can only consist of alphabetical, number and underscore'
                    }
                }
            },
            kilometres: {
            	validators: {
                    notEmpty: {
                        message: 'Kilometres is required and cannot be empty'
                    },
            		numeric: {
            			message: 'Please enter digits only'
            		},
                    regexp: {
                		regexp: /^\d+(\.\d{1,2})?$/,
                		message: 'Please round off to the nearest two decimal value'
                    }
            	}
            },
            description: {
            	validators: {
            		notEmpty: {
            			message: 'A description is required and cannot be empty'
            		}
            	}
            }
        }
    });
});

$(function() {
    $('#meeting').datetimepicker();
	$('#start').datetimepicker();
	$('#end').datetimepicker();
	$("#start").on(	"dp.change", function(e) {
		$('#end').data("DateTimePicker").setMinDate(e.date);
		$('#end').data("DateTimePicker").setValue(e.date);
        $('.form-horizontal').bootstrapValidator('revalidateField', 'start');
        $('.form-horizontal').bootstrapValidator('revalidateField', 'end');
	});
	$("#end").on("dp.change", function(e) {
		$('#start').data("DateTimePicker").setMaxDate(e.date);
        $('.form-horizontal').bootstrapValidator('revalidateField', 'start');
        $('.form-horizontal').bootstrapValidator('revalidateField', 'end');
	});
});

