<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="emc" uri="/EMC" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#content{
margin: auto;
text-align: center;
}
</style>
</head>
<body>
<c:choose>
<c:when test="${empty sessionScope.id }">
<div id="content">
로그인을 해주세요
</div>
</c:when>
<c:otherwise>
<div id="content">
<c:choose>
<c:when test="${sessionScope.grade=='G' }">
${sessionScope.id }운영자님 환영합니다.
</c:when>
<c:otherwise>
<strong>${sessionScope.id }</strong>님 환영합니다.<br>
<strong>${sessionScope.id }</strong>님의 등급은 ${emc:getGrade(sessionScope.grade) }등급 입니다.
</c:otherwise>
</c:choose>
</div>
<div id="content">
<img src="${pageContext.request.contextPath }/storage/member/${sessionScope.photo }">
</div>
</c:otherwise>
</c:choose>
</body>
</html>