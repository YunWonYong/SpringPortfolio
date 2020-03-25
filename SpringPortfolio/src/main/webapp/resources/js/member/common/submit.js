function formSubmit() {
	var $span = $("span");
	var flag = false;
	$.each($span, function(index, element) {
		console.log(index);
		console.log($(element).attr('class'));
		var className = $(element).attr('class');
		var idName = "#" + $(element).attr("id");
		console.log(idName);
		if (className == "fail_msg") {
			$(idName).html("정확히 입력해 주세요.");
			flag = false;
		} else if (className == "msg") {
			var msg = "필수 입력란 입니다.";
			if (idName == "#birth_msg") {
				msg = "필수 선택 사항입니다.";
			}
			$(idName).html(msg);
			flag = false;
		} else if (className == "success_msg") {
			flag = true;
		}

	}); 
	console.log(flag);
	if (flag) {
		$("form").submit();
	}
}