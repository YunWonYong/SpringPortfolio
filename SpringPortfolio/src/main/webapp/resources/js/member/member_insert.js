$(function() {
	var $input_password_1 = "input[name='m_password']";
	var $input_password_2 = "input[name='password_2']";
	var password = "null";
	$("input[name='m_id'],input[name='m_nickname']").change(function() {
		var target = $(this).attr('name') == "m_id" ? "id" : "nickname";
		var msg = regular(target, $(this).val());
		var ajaxTarget = target;
		target = target == "m_id" ? "#id_msg" : "#nickname_msg";
		if (msg != null) {
			$(target).html(msg);
			$(target).attr("class", "fail_msg");
			$(this).focus();
			return;
		}
		duplicateAjax($(this));
	});
	$($input_password_2).focusout(function(){
		if($(this).val()!= $($input_password_1).val()){
			$("#password_msg_2").attr('class', 'fail_msg');
		}
	});
	$($input_password_1).change(function() {
		var msg = regular("password", $(this).val());
		if (msg != null) {
			$("#password_msg_1").html(msg);
			$("#password_msg_1").attr('class', 'fail_msg');
			$(this).focus();
			return;
		}
		$("#password_msg_1").attr('class', 'success_msg');
		$("#password_msg_1").html("좋은 비밀번호입니다. 재확인해 주세요.");
		$($input_password_2).focus();
	});
	$($input_password_2).focus(function() {
		if ($("#password_msg_1").attr('class') != "success_msg") {
			$($input_password_1).focus();
			$("#password_msg_1").html("비밀번호를 먼저 입력해 주세요");
			$("#password_msg_1").attr('class', 'fail_msg');
			return;
		}
		password = $($input_password_1).val();
	});
	$($input_password_2).change(function() {
		var msg = null;
		var className = null;
		try {
			if (password != $(this).val()) {
				throw "";
			}
			msg = "비밀번호가 동일합니다.";
			className = "success_msg";
		} catch (e) {
			msg = "비밀번호가 동일하지 않습니다. 확인해 주세요.";
			className = "fail_msg";
		} finally {
			$("#password_msg_2").html(msg);
			$("#password_msg_2").attr('class', className);
		}

	});
	$("input[name='m_name']").change(function() {
		var msg = regular('name', $(this).val());
		try {
			if (msg != null) {
				throw "";
			}
			msg = $(this).val() + "(은)는 훌륭한 이름입니다.";
			className = "success_msg";
		} catch (e) {
			msg = "비밀번호가 동일하지 않습니다. 확인해 주세요.";
			className = "fail_msg";
		} finally {
			$("#name_msg").html(msg);
			$("#name_msg").attr('class', className);
		}
	});
	$("input[type='radio']").click(function() {
		$($(this).attr("id") == "woman"?"input[id='man']":"input[id='woman']").prop("checked", false);
	});
	
	$("input[name='m_zipcode'],input[name='m_address1'],input[name='m_address2']").click(function(){
		var msg = $("input[name='m_zipcode']").val()==""?"주소를 입력하시겠습니까?":"주소를 수정하겠습니까?";
		if(confirm(msg)){
			daumPostcode();
			$("input[name='m_zipcode'],input[name='m_address1'],input[name='m_address2']").val('');
			$("input[name='m_address2']").focus();
			$("#address2_msg").attr('class','fail_msg');
			return;
		}
	});
	$("select[name='year'],select[name='month'],select[name='date']").dblclick(function(){
	});
	$("input[name='m_address2']").change(function(){
		if($(this).val().length==0){
			$("#address2_msg").attr('class','fail_msg');
			$("#address2_msg").html("상세주소를 입력해 주세요.");
			$(this).focus();
			return;
		}
		$("#address2_msg").html("");
		$("#address2_msg").attr('class','success_msg');
	});
	$("input[name='m_phone']").change(function(){
		var msg = regular('phone', $(this).val());
		if(msg != null){
			$("#phone_msg").attr('class','fail_msg');
			$("#phone_msg").html(msg);
			$(this).focus();
			return;
		}
		$("#phone_msg").attr('class','success_msg');
		$("#phone_msg").html(" ");
	});
});