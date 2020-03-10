<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width initial-scale=1">
<link rel="stylesheet" href="/resources/css/member/member_list.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >

<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript"src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/common/dateSplit.js"></script>
<script src="https://kit.fontawesome.com/84ab9164ab.js"></script>
<script type="text/javascript">
	$(function() {
		var $target = null;
		var $content = null;

		$("#search").click(
				function() {
					$target = $("select[name='target']").val();
					$content = $("input[name='content']");
					var content = $($content).val();
					/* a-z|a-zA-Z|a-z0-9|a-z가-힣|A-Z|A-Za-z|A-Z0-9|A-Z가-힣|0-9a-z|0-9A-Z|0-9가-힣 */
					var textCheck = !/^[a-zA-Z가-힣0-9]*$/.test(content) ? true
							: false;
					var targetCheck = $target == "m_index"
							|| $target == "m_age";
					var m_indentCheck = targetCheck
							&& (!(/^[0-9]*$/).test(content)) ? true : false;
					var stringCheck = !(targetCheck && textCheck) ? true
							: false;
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
			getData([ null, null, 1 ]);
		});
		getData([ $target, $content, 1 ]);

	});
	function getData(arr) {
		console.log(arr);
		$.ajax({
			type : 'get',
			url : '/member/view/list',
			data : {
				target : arr[0],
				content : arr[1],
				currentPage : arr[2]
			},
			success : function(data) {
				console.log(data);
				var jsonData = JSON.parse(data);
				var msg = "<table class='table'><thead><tr>" + "<th>회원번호</th>"
						+ "<th>아이디</th>" + "<th>닉네임</th>" + "<th>이름</th>"
						+ "<th>나이</th>" + "<th>성별</th>" + "<th>등급</th>"
						+ "<th>가입날짜</th>" + "</tr></thead>";
				try {
					msg += "<tbody>";
					if (data.length == 0) {
						throw "<tr><td colspan='8'>조회할 회원이 없습니다.</td></tr>";
					}
					var arrs = jsonData.memberdto;
					$.each(arrs, function(i, dto) {
						msg += "<tr><td>" + dto.m_index + "</td>";
						msg += "<td><a href='/member/read/"+dto.m_index+"'>";
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
					if (paging.stopNumber == 0) {
						msg += "<a href='javascript:pageFunction("
								+ paging.beginNumber + ")'>"
								+ paging.beginNumber + "</a>";
					} else {
						var curr = paging.currentPage;
						if(curr >10){
							msg += "<a href='javascript:pageFunction(" + 1
							+ ")'><i class='fas fa-angle-double-left'></i></a>&nbsp";
						}
						if (curr > 1) {
						
							msg += "<a href='javascript:pageFunction("
									+ (curr - 1) + ")'><i class='fas fa-angle-left'></i></a>&nbsp";
						}
						msg+="</div>";
						msg+="<div>"; 
						for (var i = paging.beginNumber; i < paging.stopNumber + 1; i++) {
							var linkColor = curr == i ? "style='color:red;'"
									: "";
							msg += "<a href='javascript:pageFunction(" + i
									+ ")'" + linkColor + ">" + i + "</a>&nbsp";
						}
						msg+="</div><div>";
						if (curr != paging.totalPage) {
							msg += "<a href='javascript:pageFunction("
									+ (curr + 1) + ")'><i class='fas fa-angle-right'></i></a>&nbsp";
							msg += "<a href='javascript:pageFunction("
								+ paging.totalPage + ")'><i class='fas fa-angle-double-right'></i></a>&nbsp";
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
</script>
</head>
<body>
<div class="wrap">
	<div class="logo">
		<h1>회원리스트 로고</h1>
	</div>
	
		<div class="member_list_search">
			<div class="member_search_target">
				<select name="target">
					<option value="m_index">회원번호</option>
					<option value="m_grant">회원등급</option>
					<option value="m_id">아이디</option>
					<option value="m_nickname">닉네임</option>
					<option value="m_name">이름</option>
					<option value="m_age">나이</option>
					<option value="m_gender">성별</option>
					<!-- <optgroup label="성별">
					<option value="0">남자</option>
					<option value="1">여자</option>
					</optgroup> -->
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
		<div class="all_list">
		
			<button id='all_list'>전체리스트</button>
		</div>
	</div>
</body>
</html>