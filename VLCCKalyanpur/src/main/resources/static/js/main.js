/**
 * 
 */

$(document).ready(function() {

	$('.table #editbtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(Login, status) {
			$('.editForm #userName').val(Login.userName);
			$('.editForm #first_name').val(Login.first_name);
			$('.editForm #last_name').val(Login.last_name);
			$('.editForm #email').val(Login.email);
			$('.editForm #password').val(Login.password);
			$('.editForm #mobileNumber').val(Login.mobileNumber);
		});
		$('.editForm #editmodal').modal();

	});

	$('.table #deletebtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #btnYes').attr('href', href);
		$('#deleteModal').modal();
	});

});