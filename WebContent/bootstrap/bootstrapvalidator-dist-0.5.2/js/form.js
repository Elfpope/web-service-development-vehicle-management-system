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
                    },
                    regexp: {
                    	regexp: '.*@.*\.(com|gov|org|net|edu)\.?.*',
                    		message: "Email address must end in .com, .gov, .org, .net or .edu"
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
                		message: 'Kilometres must be a positive number and rounded to the nearest two decimal value'
                    }
            	}
            },
            description: {
            	validators: {
            		notEmpty: {
            			message: 'A description is required and cannot be empty'
            		}
            	}
            },
            regoNumber: {
            	validators: {
            		notEmpty: {
            			message: 'A vehicle registration number is required and cannot be empty'
            		},
            		regexp: {
            			regexp: /[A-Z]{3}[0-9]{3}/,
            			message: 'Registration number must be in the format of XXX000' 
            		}
            	}
            },
            type: {
            	validators: {
            		notEmpty: {
            			message: 'A vehicle type is required and cannot be empty'
            		}
            	}
            },
            make: {
            	validators: {
            		notEmpty: {
            			message: 'A vehicle make is required and cannot be empty'
            		}
            	}
            },
            model: {
            	validators: {
            		notEmpty: {
            			message: 'A vehicle model is required and cannot be empty'
            		}
            	}
            },
            colour: {
            	validators: {
            		notEmpty: {
            			message: 'A vehicle colour is required and cannot be empty'
            		}
            	}
            },
            firstName: {
            	validators: {
            		notEmpty: {
            			message: 'First Name is required and cannot be empty'
            		}
            	}
            },
            lastName: {
            	validators: {
            		notEmpty: {
            			message: 'Last Name is required and cannot be empty'
            		}
            	}
            },
            password: {
            	validators: {
            		notEmpty: {
            			message: 'A password is required and cannot be empty'
            		}
            	}
            },
            confirmPassword: {
            	validators: {
            		notEmpty: {
            			message: 'A password is required and cannot be empty'
            		},
                 	identical: {
                            field: 'password',
                            message: 'Password does not match'
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

