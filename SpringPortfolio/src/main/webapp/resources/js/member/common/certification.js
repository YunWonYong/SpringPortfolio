$(function() {
	var $email = $("input[name='m_email']");
	var oldEmail = $($email).val();
	$("#certification").click(function() {
		ajaxFunction([$($email).val(),"update"]);
	});
	function ajaxFunction(arr) {
		$.ajax({
			type:'get',
			url:'/certification/inspection',
			data:{to:arr[0],from:arr[1]},
			success:function(data){
				console.log(data);
			}
		});
	}
});
