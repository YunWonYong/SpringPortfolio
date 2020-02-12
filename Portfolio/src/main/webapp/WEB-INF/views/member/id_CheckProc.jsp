<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function windowclose(){
	window.close();
}
function id_CheckForm(){
	url="./idCheck";
	location.href=url;
}
</script>
</head>
<body>
<c:choose>
<c:when test="${cnt==1 }">
<div>
${id }는 중복된 아이디입니다<br>
<input type="button" value="다시시도" onclick="id_CheckForm()"/>
<input type="button" value="취소" onclick="windowclose()"/>
</div>
</c:when>
<c:otherwise>
${id }는 사용 가능한 아이디입니다<br>
<input type="button" value="사용" onclick="windowclose()"/>
</c:otherwise>
</c:choose>
</body>
</html>