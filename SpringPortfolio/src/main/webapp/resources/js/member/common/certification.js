$(function() {
	var $email = $("input[name='m_email']");
	$("#certification_update,#certification_insert").click(function() {
				var msg = regular('email',$($email).val());
				if (msg!=null) {
					$("#email_msg").html(msg);
					$("#email_msg").attr('class','fail_msg');
					$($email).focus();
					return; 
				}
				var from = $(this).attr("id");
				from = from.split("_")[1];
				ajaxFunction([ '/certification/inspection', $($email).val(),
						from, $email ]);
			});
	$($email).focusout(
			function() { 
				if ($("#email_msg").attr("class") == "success_msg") {
					$("#email_msg").html("인증이 완료되었습니다.");
					return;
				}
				var msg = regular('email',$($email).val());
				if (msg!=null) {
					$("#email_msg").html(msg);
					$("#email_msg").attr('class','fail_msg');
					$($email).focus();
					return; 
				}
				ajaxFunction([ '/certification/read', $($email).val(), "read",
						$email ]);
			});
	function ajaxFunction(arr) {
		var url = arr[0];
		var from = arr[2];
		var input = arr[3];
		$.ajax({
			type : 'get',
			url : url,
			data : {
				to : arr[1],
				from : from
			},
			success : function(data) {
				if (from == "update" || from == "insert") {
					$("#email_msg").html(data);
					$(input).focus();
				} else {
					if (data == "ok") {
						$("#email_msg").attr('class', 'success_msg');
						$("#email_msg").html("인증이 완료되었습니다.");
					}else if(data =="stay"){
						$("#email_msg").attr('class',  'fail_msg');
						$("#email_msg").html("이메일 발송 중 입니다. 잠시만 기달려 주세요.");
					}else {
						$("#email_msg").attr('class', 'fail_msg'); 
						$("#email_msg").html("인증이 안되었습니다. 다시 시도해주세요.");
						$(input).focus();
					}
				}
			}
		});
	}
});
