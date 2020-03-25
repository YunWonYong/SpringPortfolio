$(function() {
	var $c = $("#certification_key");
	var $password = $("#password_1");
	$c.hide();
	if ($($c).text().length > 0) {
		$("#submit").attr('href', '#');
	}
	$("#email_msg").attr('class', 'fail_msg');
	$("#email_msg").attr('id', 'fail_email');
	$("#password_2,#password_3").focus(function() {
		var flag = passwordCheck("기존 비밀번호를 먼저 확인해주세요.");
	}); 
	$("#password_1").focusout(function() {
		$.ajax({
			type : 'get',
			url : '/member/passwordCheck',
			data :{m_password :$($password).val()},
			success : function(data){
				if(data == "no"){
					alert("로그인을 해주세요.");
					location.href="/";
				}
				$("#password_msg_old").html(data);
				if(data == "비밀번호를 확인 되셨습니다."){
					$("#password_msg_old").attr("class","success_password_old");
				}
			}
		});
	});

	function passwordCheck(msg) {
		var flag = true;
		if ($($password).val() == '') {
			$("#password_msg_old").html(msg);
			flag = false;
			$($password).focus();
		}
		return flag;
	}
});