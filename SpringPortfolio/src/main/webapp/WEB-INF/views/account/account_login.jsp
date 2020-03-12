<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="account_login_log">
	<!-- <img src="로그" alt="없으면 전쟁임"> -->
</div>
<div id="account_form">
	<form action="/account/login" method="POST" onSubmit="return false;">
		<div id="account_input_id">
			<label for="m_id">아이디</label> <input name="m_id" id="m_id"
				value="${not empty m_id?m_id:'' }" />
		</div>
		<div id="account_input_password">
			<label for="m_password">비밀번호</label> <input type="password"
				name="m_password" id="m_password" />
		</div>
		<div id="account_fail_msg">
			<strong>${not empty msg?msg:'&nbsp;' }</strong>
		</div>
		<div id="account_form_submit">
			<input type="checkbox" name="a_autologin_check" value="off" id="autologin" />
			<label for="autologin">자동로그인</label>
			<button id="form_submit">로그인</button>
		</div>
	</form>
</div>
<div id="account_button">
	<button>아이디 찾기</button>
	<button>비밀번호 찾기</button>
	<button>회원가입</button>
</div>
