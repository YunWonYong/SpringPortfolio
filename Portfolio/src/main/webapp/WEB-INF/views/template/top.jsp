<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath }" var="root" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Template TOP</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${root }">Portfolio</a>
		</div>
		<ul class="nav navbar-nav">
			<c:choose>
				<c:when test="${empty sessionScope.id }">
					<li><a href="${root }/member/create">회원가입</a></li>
					<li><a href="${root }/member/login">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${root }/member/logout">로그아웃</a></li>
					<li><a href="${root }/member/read?id=${sessionScope.id}">회원정보</a></li>
					<li><a href="${root }/member/update?id=${sessionScope.id }">회원수정</a></li>
					<c:if test="${sessionScope.grade=='G' }">
					<li><a href="${root }/member/list">회원목록</a></li>
					</c:if>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	</nav>
</body>
</html>
