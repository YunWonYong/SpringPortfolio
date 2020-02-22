$(function() {
	var $year = $("select[name='year']");
	var $month = $("select[name='month']");
	var $id_input = $("input[name='m_id']");
	var $name_input =$("input[name='m_name']");
	var $password_1 = $("input[name='m_password']");
	var $password_2 = $("input[name='password_2']");
	var $genderMan = $("input[name = 'genderCheck']");
	var $genderWoman = $("#woman");
	var $email = $("input[name = 'm_email']");
	
	var $old_year = $year.val();
	var $old_month = $month.val();
	var $new_year = null;
	var $new_month = null;
	var $date = $("select[name='date']");
	var dbTarget = "";
	$($year).change(function() {
		$new_year = $(this).val();
		$old_year = null;
		dateChange([$new_year,$old_month,$new_month]);
	});
	$($month).change(function() {
		$new_month = $(this).val();
		$old_month = null;
		dateChange([$old_year,$new_year,$new_month]);
	});
	
	
	$($id_input).change(function() {
						var id = $id_input.val();
						dbTarget = "m_id";
						var msg = !(id.length >= 5 && id.length <= 12) ? "최소 5글자 최대 12글자 입니다.":
								   (/[.*\s.*]/.test(id))?"공백을 포함할수 없습니다.":
									   (/^[0-9]/.test(id))?"숫자로 시작하실수 없습니다.":
										   (/[ㄱ-ㅎ|가-힣|ㅏ-ㅣ|ㄱ-ㅎ가-힣ㅏ-ㅣ]/.test(id))?"한글은 사용하실수 없습니다.":
											   !(/^[a-zA-Z0-9]*$/.test(id))?"특수문자를 포함할수 없습니다."
												: null;
						if(msg==null){
							duplicateAjax([dbTarget,id]);
							return;
						}
						msgSwith(msg,"#id_msg");
						
					});

	$($password_1).change(function() {
						var password_1 = $password_1.val();
						var msg = !((password_1.length >= 8) && (password_1.length <= 15)) ? "최소 8글자 최대 15글자"
								: !(/^[a-zA-Z]+/.test(password_1)) ? "영문 대소문자로 시작해야 합니다."
									: !(/.*[!|@|#|$|%|&|*|^|~]+/.test(password_1)) ? "특수문자 한개 이상 포함해야 합니다.(~,!,@,#,$,%,&,^,*)"
										: null;
						msgSwith(msg, "#password_msg_1");
					});
	
	$($password_2).focus(function(){
		var msg = null;
		var password_1=$($password_1).val();
		if(password_1==''){
			msg = "비밀번호를 먼저 입력해 주세요.";
			msgSwith(msg, "#password_msg_2");
			$($password_1).focus();
		}else{
			$("#fail_password_2").html("&nbsp;");
			passwordCheck(password_1,$($password_2));
		}
	});
	
	$($name_input).change(function(){
		var name = $name_input.val();
		var msg = !((name.length>=2) && (name.length<=5))?"2이상 5글자 이하 입니다.":
				   		(/.*\s.*/.test(name))?"공백을 포함할수 없습니다.":
				   			(/^[ㄱ-ㅎ||ㅏ-ㅣ||ㄱ-ㅎㅏ-ㅣ]*$/.test(name))?"자음 또는 모음은 사용할수 없습니다.":
				   				!(/^[가-힣]*$/.test(name))?"한글만 입력가능합니다."
						   :null;
		msgSwith(msg, "#name_msg");
	});
	
	
	$("input[type='radio']").click(function(){
		var id = $(this).attr("id");
		var arr = $("input[type='radio']");
		var value = null;
		$.each(arr,function(i){
		/*	if($(arr[i]).attr("id")==id){
				$(arr[i]).prop('checked',true);
			}else{
				$(arr[i]).prop('checked',false);
			}*/
			
			if($(arr[i]).attr("id")==id){
				$(arr[i]).attr("checked","checked");
			}else{
				$(arr[i]).removeAttr("checked");
			}
		});
	});
	
	
	
	dateChange([$old_year,$old_month]);
}); 

function successMsg(target) {
	var msg= "사용하셔도 좋은 ";
	switch (target) {
	case "#id_msg":
		msg+="아이디";
		break;
	case "#password_msg_1":
		return "비밀번호를 확인해주세요.";
	case "#password_msg_2":
		msg+="비밀번호";
		break;
	case "#name_msg":
		return "&nbsp;";
	default:
		break;
	}
	return 	msg+= " 입니다.";
}
function setMsgSelecter(target,select){
	switch (target) {
	case "#id_msg":
		select+="_id";
		break;
	case "#password_msg_1":
		select+="_password_1";
		break;
	case "#password_msg_2":
		select+="_password_2";
		break;
	case "#name_msg":
		select+="_name";
		break;
	default:
		break;
	}
	return select;
}
function msgSwith(msg, target) {
	var select = (msg!=null) ? 'fail' : 'success';
	var change = (msg!=null) ? 'success' :'fail';  
	var msgSelector = null;
	var changeId = null;
	var changeClass = null;
	
	var idSelecter = null;
	var classSelector = null;
	
	var continueValue = null;
	msgSelector = setMsgSelecter(target,select);  
	classSelector = "."+msgSelector.replace(select,change); 
	continueValue = $(classSelector).attr("id");
	idSelecter =($(target).attr("id")!=undefined)?target:
				(continueValue==undefined)?"#"+msgSelector:"#"+continueValue;
	changeId=msgSelector;
	changeClass=msgSelector;
	console.log(idSelecter);
	msg = (msg==null) ? successMsg(target) : msg;
	$(idSelecter).attr("class",changeClass); 
	$(idSelecter).html(msg);
	$(idSelecter).attr("id",changeId);
}

function duplicateAjax(arr) {
	var target = arr[0];
	var duplicateValue = arr[1];
	$.ajax({
			type : 'POST',
			url : '/member/duplicate',
			data : {
				target : target,
				value : duplicateValue
			},
			dateType : 'text',
			success : function(result) {
				var selecter=target=="m_id"?"#id_msg":"#nickname_msg";
				if(eval(result)){
					msgSwith("중복된"+((target=="m_id")?" 아이디 ":" 닉네임 ")+"입니다.",selecter);
					return;
				}
				msgSwith(null,selecter);
			}
	/*		,
			complete:function(){
				return msg;
			}*/
		});
}
function passwordCheck(password_1,password_2){
	var msg = null;
	$(password_2).change(function(){
		password_2 = $(this).val();
		if(password_1!=password_2){
			msg = "비밀번호가 맞지 않습니다.";
			$(this).val(""); 
			$(this).focus();
		}
		if(msg==null){
			$("#success_password_1").html("&nbsp;");
		}
		msgSwith(msg, "#password_msg_2");
	});
}


function dateChange(arr) {
	var date =new Array();
	var j = 0;
	$.each(arr,function(i){
		if(arr[i]!=null){
			date[j]=arr[i];
			j++;
		}
		
	});
	getDate(date[0],date[1]);
}
function getDate(year, month) {
	var date = new Date(year, month, 0).getDate();
	$("#date").html("");
	var value;
	for (var i = 0; i <= date; i++) {
		value = String(i).length == 1 ? "0" + i : i;
		$("#date").append("<option value='" + i + "'>" + value + "</option>");
	}
}

/*******************************************************************************
 * address function
 * 
 ******************************************************************************/
function daumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var fullAddr = ''; // 최종 주소 변수
			var extraAddr = ''; // 조합형 주소 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				fullAddr = data.roadAddress;

			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				fullAddr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다.
				if (data.bname !== '') {
					extraAddr += data.bname;
				}
				// 건물명이 있을 경우 추가한다.
				if (data.buildingName !== '') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
				fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('m_zipcode').value = data.zonecode; // 5자리
			// 새우편번호
			// 사용
			document.getElementById('m_address1').value = fullAddr;

			// 커서를 상세주소 필드로 이동한다.
			document.getElementById('m_address2').focus();
		}
	}).open();
}