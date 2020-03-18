<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="/resources/css/common/css/default.css">
<meta charset="UTF-8">
<script type="text/javascript">
	function formSubmit() {
		alert("test");
	}
	$(function(){
	});
</script>
</head>
<body>
	
	<div class="wrap">
		<div class="title">
			<span class="font">${title}</span>
		</div>
		<div class="form">
			<form action="/member/update" method="post">
				<div class="input">
					${input}
				</div>
			</form>
		</div>
		<div class="btn">
			<a href='javascript:formSubmit()'>수정</a> 
			<a href='javascript:window.history.back()'>되돌아가기</a>
		</div>
	</div>
</body>
</html>