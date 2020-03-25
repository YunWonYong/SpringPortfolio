$(function() {
	var $email = $("input[name='m_email']");
	$("#certification").click(
			function() {

				ajaxFunction([ '/certification/inspection', $($email).val(),
						"update", $email ]);
			});
	$("#submit").click(
			function() {
				if ($("span").attr('id')=="#success_email") {
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
					$("#fail_email").html(data);
					$(input).focus();
				} else {
					if (data == "ok") {
						$("#fail_email").attr('class', 'success_msg');
						$("#fail_email").attr('id', 'success_email');
						$("#success_email").html("인증이 완료되었습니다.");
					} else {
						$("#fail_email").html("인증이 안되었습니다. 다시 시도해주세요.");
						$(input).focus();
					}
				}
			}
		});
	}
});
