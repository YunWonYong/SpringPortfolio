<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/member/member_insert.css">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript"
	src="/resources/js/member/member_insert.js"></script>
<style>
thead, tbody {
	display: inline;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="member_title ">
		<h1>회원가입</h1>
	</div>
	<div class="wrap">
		<div class="form ">
			<form class="login-form" action="/member/insert" method="POST">
				<div class="input">
					<div class="id">
						<p>아이디</p>
						<input class="txtb" required type="text" name="m_id"> <span
							id="id_msg" class="msg">&nbsp;</span>
					</div>
					<div class='pw'>
						<p>비밀번호</p>
						<input class='txtb' type='password' name='m_password'
							id='password_1' /> <span id='password_msg_1' class='msg'>&nbsp;</span>
					</div>

					<div class='pwcheck'>
						<p>비밀번호 재확인</p>
						<input class='txtb' type='password' name='password_2'
							id='password_2' /> <span id='password_msg_2' class='msg'>&nbsp;</span>
					</div>

					<div>
						<p>닉네임</p>
						<input class="txtb" type="text" name="m_nickname" /> <span
							id="nickname_msg" class="msg">&nbsp;</span>
					</div>

					<div class="name">
						<p>이름</p>
						<!-- <label for="m_name"></label>  -->
						<input class="txtb" type="text" name="m_name" />
					</div>

					<div class="gender">
						<div>성별</div>
						<div class="man">
							<input type="radio" name="genderCheck" id="man" checked="checked" />
							<label for="man">남자</label> <span id="gender_msg" class="msg">&nbsp;</span>
						</div>
						<div class="girl">
							<input type="radio" id="woman" /> <label for="woman">여자</label>
						</div>
					</div>
					<div class="birth">
						<p>생년월일</p>
						<select name="year">
							<c:forEach items="${util.year }" var="year">
								<option value="${year }">${year }</option>
							</c:forEach>
						</select>
						<samp style="font-size: 20px;">-</samp>
						<select name="month">
							<c:forEach items="${util.month }" var="month">
								<option value="${month }">${month }</option>
							</c:forEach>
						</select>
						<samp style="font-size: 20px;">-</samp>
						<select name="date" id="date">
							<option value="00">00</option>
						</select> <span id="birth_msg" class="msg">&nbsp;</span>
					</div>

					<div class="email">
						<p>이메일</p>
						<input class="txtb" type="text" name="m_email"> <span
							id="email_msg" class="msg">&nbsp;</span>
					</div>

					<div class="phone">
						<p>핸드폰 번호</p>
						<input class="txtb" name="m_phone"> <span id="phone_msg"
							class="msg">&nbsp;</span>
					</div>

					<div class="zipcode">
						<p>우편번호</p>
						<input class="txtb" name="m_zipcode" id="m_zipcode">
						<button onclick="daumPostcode()">우편찾기</button>
					</div>

					<div class="adress">
						<p>주소</p>
						<input class="txtb" name="m_address1" id="m_address1"> <span
							id="adress1_msg" class="msg">&nbsp;</span>
					</div>
					<div class="adress2">
						<p>상세주소</p>
						<input class="txtb" name="m_address2" id="m_address2" required>
						<span id="adress2_msg" class="msg">&nbsp;</span>
					</div>
				</div>
			</form>
		</div>
		<div class="btn">
			<input class=".txtb" type="submit" name="" value="회원가입">
		</div>
	</div>
</body>
</html>