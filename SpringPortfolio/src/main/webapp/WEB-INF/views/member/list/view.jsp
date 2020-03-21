<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">

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