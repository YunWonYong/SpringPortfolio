<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/account/account_login.js"></script>
<title>login</title>
</head>
<body>
	<div id="account_login_log">
		<!-- <img src="로그" alt="없으면 전쟁임"> -->
	</div>
	<div id="account_form">
		<form action="/account/login" method="POST">
			<div id="account_input_id">
				<label for="m_id">아이디</label> 
				<input name="m_id" id="m_id" value="${not empty m_id?m_id:'' }" />
			</div>
			<div id="account_input_password">
				<label for="m_password">비밀번호</label> 
				<input type="password"name="m_password" id="m_password" />
			</div>
			<div id="account_fail_msg">
				<strong> <c:choose>
						<c:when test="${not empty msg }">
							${msg }
						</c:when>
						<c:otherwise>
							&nbsp;			 		
						</c:otherwise>
					</c:choose>
				</strong>
			</div>
		</form>
		<div id="account_form_submit">
			<button id="form_submit">로그인</button>
		</div>
	</div>
	<div id="account_button">
		<button>아이디 찾기</button>
		<button>비밀번호 찾기</button>
		<button>회원가입</button>
	</div>
</body>
</html>