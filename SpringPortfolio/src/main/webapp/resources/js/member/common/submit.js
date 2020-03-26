function insertFormSubmit() {
	var $span = $("span");
	var flag = new Array();
	$.each($span, function(index, element) {
		var className = $(element).attr('class');
		var idName = "#" + $(element).attr("id");
		if (className == "success_msg") {
			flag.push("true");
		} else if (className == "msg") {
			var msg = "필수 입력란 입니다.";
			if (idName == "#birth_msg") {
				msg = "필수 선택 사항입니다.";
			} 
			$(idName).html(msg);
			flag.push("false");
			
		} else if (className == "fail_msg") {
			$(idName).html("정확히 입력해 주세요.");
			flag.push("false");
		}

	});
	if (flag.indexOf("false")==-1) {
		$("form").submit();
	}
}
$(function() {
	var $initInput =$("input");
	var elementList = new Array();
	$.each($initInput, function(index,element){
		elementList.push($(element).val());
	});
	$("#updateSubmit").click(function(){
		updateFormSubmit(elementList);
	});
});
function updateFormSubmit(elementList) {
	var $inputArr = $("input");
	var flag = -1;
	$.each($inputArr,function(index,element){
		flag = elementList.indexOf($(element).val());
	});
	if(flag >- 1){
		$("form").submit();
	}
}