$(function() {
	var $c = $("#certification_key");
	var $password = $("#password_1");
	$c.hide();
	if ($($c).text().length > 0) {
		$("#submit").attr('href', '#');
	}
	$("#email_msg").attr('class', 'fail_msg');
	$("#email_msg").attr('id', 'fail_email');
	$("#password_2,#password_3").focus(function(){
		var flag = passwordCheck("기존 비밀번호를 먼저 확인해주세요.");
	});
	
	function passwordCheck(msg) {
		var flag = true;
		if ($($password).val()=='') {
			$("#password_msg_old").html(msg);
			flag = false;
			$($password).focus();
		}
		return flag;
	}
});