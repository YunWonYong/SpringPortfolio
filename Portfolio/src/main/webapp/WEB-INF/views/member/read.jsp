<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="emc" uri="/EMC"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#title {
	margin: auto;
	text-align: center;
}

#button {
	margin: auto;
	text-align: center;
}

table {
	margin: auto;
	text-align: center;
}

table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div id="title">
		<h1>회원정보</h1>
	</div>
	<table>
		<tr>
			<th colspan="2"><img
				src="${pageContext.request.contextPath }/storage/member/${dto.photo}"></th>
		</tr>
		<tr>
			<th colspan="2" style="text-align: center;">프로필사진</th>
		</tr>
		<tr>
			<th>ID</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td>${dto.nickname }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${dto.sex }</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${dto.year }년${dto.month }월${dto.day }일</td>
		</tr>
		<tr>
			<th>Email</th>
			<td>${dto.email1}${dto.at }${dto.email2}</td>
		</tr>
		<tr>
			<th>집전화번호</th>
			<td>${dto.zipnumber1 }-${dto.zipnumber2 }-${dto.zipnumber3}</td>
		</tr>
		<tr>
			<th>핸드폰번호</th>
			<td>${dto.phone1 }-${dto.phone2 }-${dto.phone3 }</td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td>${dto.zipcode }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${dto.address1 }</td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td>${dto.address2 }</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>${dto.hobby }</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${emc:getGrade(dto.grade) }</td>
		</tr>
	</table>
	<div id="button">
		<input type="button" value="글쓰기" onclick="bbs(${dto.id})" />
	</div>
</body>
</html>