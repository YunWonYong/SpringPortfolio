function duplicateAjax(element) {
	var target = $(element).attr("name"); 
	var input = element;
	$.ajax({
			type : 'POST',
			url : '/member/duplicate',
			data : {
				target : target,
				value :  $(element).val()
			},
			dateType : 'text',
			success : function(result) {
				var selecter=target=="m_id"?"#id_msg":"#nickname_msg";
				var msg = null;
				target = (target=="m_id")?" 아이디 ":" 닉네임 ";
				var flag = eval(result);
				var className = flag?"success_msg":"fail_msg";
				try{
					if(!flag){
						throw "";
					}
					msg = "사용하셔도 좋은 "+target+"입니다.";
				}catch (e) {
					msg= "중복된"+target+"입니다.";
					$(input).focus();
				}finally{
					$(selecter).html(msg);
					$(selecter).attr("class",className);
				}
			}
		});
}