$(function() {
	var $year = $("select[name='year']");
	var $month = $("select[name='month']");
	var $date = $("select[name='date']");
	var $old_year = $year.val();
	var $old_month = $month.val();
	var $new_year = null;
	var $new_month = null;
	if ($($date).val() == "00") {
		dateChange([ $old_year, $old_month ]);
	}
	dateCheck($date);
	function birthArr(msg) {
		return birthCheck([ $year, $month, $date, msg ]);
	}
	$($month).click(function() {
		if (birthArr() == 1) {
			$(this).children('option').prop('disabled', false);
			birthArr($new_year == null ? "년도를 선택해 주세요." : undefined);
		}
	});
	$($date).click(function() {
		var msg;
		if (birthArr() == 1) {
			$(this).children('option').prop('disabled', false);
			msg = $new_year == null ? "년도를 선택해 주세요." : undefined;
		} else if (birthArr() == 2) {
			msg = "월을 선택해 주세요.";
		}
		birthArr(msg);
	});
	$($year).change(function() {
		$new_year = $(this).val();
		$old_year = null;
		dateChange([ $new_year, $old_month, $new_month ]);
		if (birthArr() == 1) {
			$(this).focus();
		}
	});
	$($month).change(function() {
		$new_month = $(this).val();
		$old_month = null;
		dateChange([ $old_year, $new_year, $new_month ]);
		if (birthArr() == 2) {
			$(this).focus();
		}
	});
	$($date).change(function() {
		if (birthArr() == 4) {
			$($email_input).focus();
			emailCheck($email_input);
		}
	});

});
function dateChange(arr) {
	var date = new Array();
	var j = 0;
	$.each(arr, function(i) {
		if (arr[i] != null) {
			date[j] = arr[i];
			j++;
		}

	});
	getDate(date[0], date[1]);
}

function dateCheck(date) {
	$(date).change(function() {
		if ($(date).val() != 0) {
			msgSwith(null, "#birth_msg");
		}
	});
}
function getDate(year, month) {
	var date = new Date(year, month, 0).getDate();
	$("#date").html("");
	var value;
	for (var i = 0; i <= date; i++) {
		value = String(i).length == 1 ? "0" + i : i;
		$("#date").append("<option value='" + i + "'>" + value + "</option>");
	}
}