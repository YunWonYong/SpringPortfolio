<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function valueCheck(f){
	if(f.id.value==""||f.id.value==null){
		alert("아이디를 입력해 주세요");
		f.id.focus();
		return false;
	}
}
function windowclose(){
	window.close();
}
</script>
</head>
<body>
	<div id="title">아이디 중복 확인</div>
<form action="./idCheckProc" method="POST" onsubmit="return valueCheck(this)">
	<table>
	<tr>
	<th>아이디:</th>
	<td>
	<c:choose>
	<c:when test="${not empty id }">
	<input type="text"  name="id"  value="${id }"/>
	</c:when>
	<c:otherwise>
	<input type="text" name="id"/>
	</c:otherwise>
	</c:choose>
	</td>
	</tr>
	</table>
	<div>
	<input type="submit" value="중복확인"/>
	<input type="button" value="닫기" onclick="windowclose()"/>
	</div>
</form>
</body>
</html>