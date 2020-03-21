$(function() {
	var $target = "null";
	var $content = "null";

	$("#search").click(
			function() {
				$target = $("select[name='target']").val();
				$content = $("input[name='content']");
				var content = $($content).val();
				/* a-z|a-zA-Z|a-z0-9|a-z가-힣|A-Z|A-Za-z|A-Z0-9|A-Z가-힣|0-9a-z|0-9A-Z|0-9가-힣 */
				var textCheck = !/^[a-zA-Z가-힣0-9]*$/.test(content) ? true
						: false;
				var targetCheck = $target == "m_index" || $target == "m_age";
				var m_indentCheck = targetCheck
						&& (!(/^[0-9]*$/).test(content)) ? true : false;
				var stringCheck = !(targetCheck && textCheck) ? true : false;
				var check = content == "" ? "검색어를 입력해 주세요"
						: m_indentCheck ? "숫자만입력 가능합니다."
								: !stringCheck ? "공백 또는 특수문자를 포함할수 없습니다."
										: null;
				if (check != null) {
					alert(check);
					$($content).val("");
					$($content).focus();
					return;
				}
				getData([ $target, $content.serialize(), 1 ]);
			});
	$("#all_list").click(function() {
		$("input[name='content']").val("");
		$("option[value='m_index']").prop("selected", true);
		getData([ "null","null", 1 ]); 
	});
	getData([ $target, $content, 1 ]);

});
function getData(arr) {
	$.ajax({
			type : 'get',
			url : '/member/view/list',
			data : {
					target : arr[0],
					content : arr[1],
					currentPage : arr[2]
				}, 
			success : function(data) {
					var jsonData = JSON.parse(data);
					var arrs = jsonData.memberdto;
					var msg = "<table class='table'><thead><tr>"
							+ "<th>회원번호</th>" + "<th>아이디</th>" + "<th>닉네임</th>"
							+ "<th>이름</th>" + "<th>나이</th>" + "<th>성별</th>"
							+ "<th>등급</th>" + "<th>가입날짜</th>" + "</tr></thead>";
					try {
						msg += "<tbody>";
						if (arrs == undefined) {
							throw "<tr><td colspan='8'>조회할 회원이 없습니다.</td></tr>";
						}
						
						$.each(arrs, function(i, dto) {
							msg += "<tr><td>" + dto.m_index + "</td>";
							msg += "<td><a href='/member/read/" + dto.m_index
									+ "'>";
							msg += dto.m_id + "</a></td>";
							msg += "<td>" + dto.m_nickname + "</td>";
							msg += "<td>" + dto.m_name + "</td>";
							msg += "<td>" + dto.m_age + "</td>";
							msg += "<td>" + dto.m_gender + "</td>";
							msg += "<td>" + dto.m_grant + "</td>";
							msg += "<td>" + dateSplit(dto.m_registdate, "year")
							msg += "</td></tr>";
						});
					} catch (e) {
						msg += e;
					} finally {
						var paging = jsonData.pagingentity[0];
						msg += "</tbody></table><div class='pagnation'><div>";
						if(arrs ==undefined ){
						}else if (paging.stopNumber == 0) { 
							msg += "<a href='javascript:pageFunction("
									+ paging.beginNumber + ")'>"
									+ paging.beginNumber + "</a>";
						} else {
							var curr = paging.currentPage;
							if (curr > 10) {
								msg += "<a href='javascript:pageFunction("
										+ 1
										+ ")'><i class='fas fa-angle-double-left'></i></a>&nbsp";
							}
							if (curr > 1) {
								msg += "<a href='javascript:pageFunction("
										+ (curr - 1)
										+ ")'><i class='fas fa-angle-left'></i></a>&nbsp";
							}
							msg += "</div><div>";

							for (var i = paging.beginNumber; i < paging.stopNumber + 1; i++) {
								var linkColor = curr == i ? "style='color:red;'"
										: "";
								msg += "<a href='javascript:pageFunction(" + i
										+ ")'" + linkColor + ">" + i
										+ "</a>&nbsp";
							}
							msg += "</div><div>";
							if (curr != paging.totalPage) {
								msg += "<a href='javascript:pageFunction("
										+ (curr + 1)
										+ ")'><i class='fas fa-angle-right'></i></a>&nbsp";
								msg += "<a href='javascript:pageFunction("
										+ paging.totalPage
										+ ")'><i class='fas fa-angle-double-right'></i></a>&nbsp";
							}
						} 
						msg += "</div></div>";
						$("#member_list").html(msg);
					}
				}
			});

}
function pageFunction(crrunt) {
	var $target = $("select[name='target']").val();
	var $content = $("input[name='content']");
	var content = $($content).val();
	$target = content.length == 0 ? "null" : $target;
	content = $target == "null" ? "null" : $content.serialize();
	getData([ $target, content, crrunt ]);
}
