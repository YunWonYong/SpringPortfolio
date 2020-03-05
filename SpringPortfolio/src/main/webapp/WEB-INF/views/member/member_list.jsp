<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	$(function() {
		var $target = null;
		var $content = null;
		$("#search").click(function() {
			$target = $("select[name='target']").val();
			$content = $("input[name='content']");
			var content = $($content).val();
			/* a-z|a-zA-Z|a-z0-9|a-z가-힣|A-Z|A-Za-z|A-Z0-9|A-Z가-힣|0-9a-z|0-9A-Z|0-9가-힣 */
			var textCheck = !/^[a-zA-Z가-힣0-9]*$/.test(content)?true:false;
			var targetCheck = $target=="m_index";
			var m_indentCheck = targetCheck&&(!(/^[0-9]*$/).test(content))?true:false;
			var stringCheck = !(targetCheck && textCheck)?true:false;
			var check = content == ""?"검색어를 입력해 주세요":
							m_indentCheck?"숫자만입력 가능합니다.":
								!stringCheck?"공백 또는 특수문자를 포함할수 없습니다.":null;
			if (check!=null) {
				alert(check);
				$($content).val("");
				$($content).focus();
				return;
			}
			getData([ $target,$content.serialize()]);
		});
		getData([ $target, $content ]);
	});
	
	function getData(arr) {
		console.log(arr[1]);
		$.ajax({
			type : 'get',
			url : '/member/view/list',
			data : {
				target : arr[0],
				content : arr[1]
			},
			dataType : 'text',
			success : function(data) {
				console.log(data);
				var msg = data != "회원을 조회할수 없습니다." ? null : data;
				if (msg == null) {
					msg ="<table><thead><tr>"+
					"<th>회원번호</th>"+
					"<th>아이디</th>"+
					"<th>닉네임</th>"+
					"<th>이름</th>"+
					"<th>나이</th>"+
					"<th>성별</th>"+
					"<th>등급</th>"+
					"<th>가입날짜</th>"+
					"</tr></thead>";
					msg+="<tbody>";
					var arr = JSON.parse(data).memberdto;
					$.each(arr, function(i, dto) {
						msg +="<tr>";
						msg += "<td>"+dto.m_index+"</td>";
						msg += "<td><a href='/member/read/"+dto.m_index+"'>";
						msg += dto.m_id+"</a></td>";
					 	msg += "<td>"+dto.m_nickname+"</td>";
						msg += "<td>"+dto.m_name+"</td>";
						msg += "<td>"+dto.m_age+"</td>";
						msg += "<td>"+dto.m_gender+"</td>"; 
						msg += "<td>"+dto.m_grant+"</td>";
						msg += "<td>"+dto.m_registdate+"</td>";
						msg +="<tr>";
					});
					msg += "</tbody>";
					msg += "</table>";
				}
				$("#member_list").html(msg);
			}
		});
	}
</script>
</head>
<body>
<table>
	<tfoot>
	</tfoot>
</table>
	<div class="wrap">
		<div class="member_list_search">
			<div class="member_search_target">
				<select name="target">
					<option value="m_index">회원번호</option>
					<option value="m_grant">회원등급</option>
					<option value="m_id">아이디</option>
					<option value="m_nickname">닉네임</option>
					<option value="m_age">나이</option>
					<option value="m_gender">성별</option>
					<option value="m_registdate">가입날짜</option>
				</select>
			</div>
			<div class="member_search_value">
				<input type="text" name="content" />
			</div>
			<div class="member_search_submit">
				<button id="search">검색</button>
			</div>
		</div>
		<div class="" id="member_list"></div>
		<div class="paging"></div>
	</div>
</body>
</html>