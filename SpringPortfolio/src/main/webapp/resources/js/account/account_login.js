$(function() {
	var $m_id = null;
	var $m_password = null;
	var requestM_id = "";
	$("#form_submit").click(function() {
		if (form_submit()) {
			$("form").attr("onSubmit", "true");
		}
	});
	$("input[type='checkbox']").change(function() {
		$(this).attr("value", $(this).val() == "on" ? "off" : "on");

	});
	$("input[name=m_id]").click(function() {
		if ($(this).val() != '') {
			requestM_id = $(this).val();
			$(this).val('');
			idFocusOut($(this));
		}
	});
	function idFocusOut(target) {
		$(target).focusout(function() {
			if ($(target).val() == '' && requestM_id != '') {
				$(target).val(requestM_id);
			}
		});
	}
	function form_submit() {
		var flag = false;
		$m_id = $("input[name='m_id']").val();
		$m_password = $("input[name='m_password']").val();
		if ($m_id != '' && $m_password != '') {
			flag = true;
		}
		if (!flag) {
			var $input = $("input");
			var msg = "";
			var $input_name = new Array();
			$.each($input, function(i) {
				if ($($input[i]).val() == '') {
					$input_name += $($input[i]).attr('name');
					$input_name += $input_name.length == 4 ? "|" : $input_name
							.indexOf('m_id') > -1 ? "," : $input_name
							.indexOf('m_password') > -1 ? "." : "";
				}
			});
			msg += $input_name.indexOf(',') > -1 ? "아이디와 비밀번호를" : $input_name
					.indexOf('.') > -1 ? "비밀번호를" : "아이디를";
			msg += " 입력해 주세요.";
			$("#account_fail_msg strong").html(msg);
			if ($input_name.indexOf('.') > -1) {
				$("input[name='m_password']").focus();
				return flag;
			}
			$("input[name='m_id']").focus();
		}
		return flag;
	}
});
function videoURL(play) {
	document.getElementById("slider").src = play;
}