<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="member_title ">
	<h1>회원가입</h1>
</div>
<div class="wrap">
	<div class="form">
		<form action="/member/insert" method="POST">
			<div class="input">
				<div>
					<p>아이디</p>
					<input class="txtb" required type="text" name="m_id"/> 
					<span id="id_msg" class="msg">&nbsp;</span>
				</div>
				<div>
					<p>비밀번호</p>
					<input class='txtb' type='password' name='m_password'id='password_1' /> 
					<span id='password_msg_1' class='msg'>&nbsp;</span>
				</div>

				<div>
					<p>비밀번호 재확인</p>
					<input class='txtb' type='password' name='password_2' id='password_2' />
					 <span id='password_msg_2' class='msg'>&nbsp;</span>
				</div>

				<div>
					<p>닉네임</p>
					<input class="txtb" type="text" name="m_nickname" /> 
					<span id="nickname_msg" class="msg">&nbsp;</span>
				</div>

				<div>
					<p>이름</p>
					<input class="txtb" type="text" name="m_name" />
					<span id="name_msg" class="msg">&nbsp;</span>
				</div>

				<div class="radiosort">
					<p>성별</p>
					<label for="man">남자</label> 
					<input type="radio" name="genderCheck" id="man" checked/>
					<label for="woman">여자</label>
					<input type="radio" id="woman" /> 
				
				</div>

				<div class="selectsort">
					<p>생년월일</p>
					<select name="year">
						<c:forEach items="${util.year }" var="year">
							<option value="${year }">${year }</option>
						</c:forEach>
					</select>
					
					<span><i class='fa fa-minus' aria-hidden='true'></i></span>
					<select name="month">
						<c:forEach items="${util.month }" var="month">
							<option value="${month }">${month }</option>
						</c:forEach>
					</select>
					
					<span><i class='fa fa-minus' aria-hidden='true'></i></span>
					<select name="date" id="date">
					</select> 
					<span id="birth_msg" class="msg">&nbsp;</span>
				</div>

				<div>
					<p>이메일</p>
					<input class="txtb" type="text" name="m_email" />
					<button type="button" id ='certification_insert'>이메일인증</button>
					<span id="email_msg" class="msg">&nbsp;</span>
				</div>

				<div>
					<p>핸드폰 번호</p>
					<input class="txtb" name="m_phone"> 
					<span id="phone_msg" class="msg">&nbsp;</span>
				</div>

				<div class="zipcode">
					<p>우편번호</p>
					<input class="txtb" name="m_zipcode" id="m_zipcode" readonly/>
					<button type = "button" onclick="daumPostcode()">우편찾기</button>
				</div>

				<div class="address1">
					<p>주소</p>
					<input class="txtb" name="m_address1" id="m_address1" readonly/>
				</div>

				<div class="address2">
					<p>상세주소</p>
					<input class="txtb" name="m_address2" id="m_address2" >
					<span id="address2_msg" class="msg">&nbsp;</span>
				</div>

			</div>
		</form>
	</div>
	<div class="btn">
		<a href='javascript:insertFormSubmit()' id = "submit">회원가입</a>
	</div>
</div>
