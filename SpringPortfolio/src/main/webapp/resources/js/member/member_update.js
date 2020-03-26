$(function() {
	var $c = $("#certification_key");
	var $password = $("#password_1");

	$c.hide();
	if ($($c).text().length > 0) {
		$("#submit").attr('href', '#');
	}
	
	$("#password_2,#password_3").focus(function() {
		if($("#password_msg_old").attr('class')=='success_msg'){
			return;
		}
		$("#password_msg_old").attr('class','fail_msg');
		$("#password_msg_old").html("기존 비밀번호를 먼저 인증 해주세요.");
		$($password).focus();
		
	});
	$($password).focusout(
			function() {
				$.ajax({
					type : 'get',
					url : '/member/passwordCheck',
					data : {
						m_password : $($password).val()
					},
					success : function(data) {
						if (data == "no") {
							alert("로그인을 해주세요.");
							location.href = "/account/login";
						}
						var className = "fail_msg";
						if (data == "비밀번호를 확인 되셨습니다.") {
							className = "success_msg";
							$("#password_2").focus();
						}
						$("#password_msg_old").html(data);
						$("#password_msg_old").attr("class",className);
						if(className=="fail_msg"){ 
							$($password).focus();
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
	$("input[name='m_password']").change(function() {
		var msg = regular('password', $(this).val());
		if ($("#password_1").val() == $(this).val()) {
			msg = "기존 비밀번호와 같습니다. 다시입력해 주세요.";
		}
		var className = msg != null ? "fail_msg" : "success_msg";
		$("#password_msg_1").html(msg == null ? "수정할 비밀번호를 확인해 주세요." : msg);
		$("#password_msg_1").attr('class', className);
		if (msg != null) {
			$(this).focus();
			return;
		}
		$("#password_3").focus();

	});
	$("#password_3").change(function() {
		var msg = "비밀번호가 일치합니다.";
		var className = "success_msg";
		if($("input[name='m_password']").val()==""){
			msg = "수정할 비밀번호를 먼저 입력해주세요.";
			$("input[name='m_password']").focus();
		}else if ($("input[name='m_password']").val()!=$(this).val()) {
			msg = "비밀번호가 일지하지 않습니다.";
			className = "fail_msg";
			$(this).focus();
		}
		$("#password_msg_2").html(msg);
		$("#password_msg_2").attr('class', className);
	});
	
});