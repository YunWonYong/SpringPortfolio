$(function() {
	var $year = $("select[name='year']");
	var $month = $("select[name='month']");
	var $date = $("select[name='date']");
	var $old_year = $year.val();
	var $old_month = $month.val();
	var $new_year = null; 
	var $new_month = null;
	$($year).change(function() {
		$new_year = $(this).val();
		$old_year = null;
		dateChange([ $new_year, $old_month, $new_month ]);
		$("#birth_msg").attr('class','fail_msg');
		$("#birth_msg").html(ageCheck());
	});
	$($month).change(function() {
		$new_month = $(this).val();
		$old_month = null;
		dateChange([ $old_year, $new_year, $new_month ]);
		$("#birth_msg").attr('class','fail_msg');
	});
	$($date).change(function(){
		$("#birth_msg").html(ageCheck());
	});
	function ageCheck(){
		var className = "success_msg";
		var msg = null;
		if((new Date().getFullYear())-$($year).val()<12){
			className = "fail_msg";
			msg = "만 12세부터 가입이 가능합니다.";
		}
		$("#birth_msg").attr('class',className);
		return msg;
	}
	dateChange([$old_year, $old_month ]);
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
function getDate(year, month) {
	var date = new Date(year, month, 0).getDate();
	$("#date").html("");
	var value;
	for (var i =1; i <= date; i++) {
		value = String(i).length == 1 ? "0" + i : i;
		$("#date").append("<option value='" + i + "'>" + value + "</option>");
	}
}