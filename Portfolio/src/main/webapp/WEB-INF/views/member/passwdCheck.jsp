<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Password Check</title>
</head>
<body>
<div id="title">비밀번호 확인</div>
<form action="${pageContext.request.contextPath }/member/passwdCheckProc" method="POST">
<input type="hidden" name="url" value="${url}"/>
<input type="hidden" name="id" value="${dto.id }"/>
<table>
<tr>
<th>아이디</th>
<td>${dto.id}</td>
</tr>
<tr>
<th>비밀번호</th>
<td><input type="password" name="passwd"/></td>
</tr>
</table>
<div id="button">
<input type="submit" value="확인"/>
<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}'"/>
</div>
</form>
</body>
</html>