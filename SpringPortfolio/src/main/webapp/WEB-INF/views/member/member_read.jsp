<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="wrap">
		<div class="member_read">
			<div class="left column">
				<p>
					<span>회원번호</span>
				</p>
				<p>
					<span>회원이름</span>
				</p>
				<p>
					<span>아이디</span>
				</p>
				<p>
					<span>닉네임</span>
				</p>
				<p>
					<span>생일</span>
				</p>
				<p>
					<span>나이</span>
				</p>
				<p>
					<span>우편번호</span>
				</p>
				<p>
					<span>주소</span>
				</p>
				<p>
					<span>이메일</span>
				</p>
				<p>
					<span>전화번호</span>
				</p>
				<p>
					<span>성별</span>
				</p>
				<p>
					<span>등급</span>
				</p>
				<p>
					<span>가입날짜</span>
				</p>
			</div>
			<div class="right value">
				<p>
					<span>${dto.m_index    }</span>
				</p>
				<p>
					<span>${dto.m_name     }</span>
				</p>
				<p>
					<span>${dto.m_id       }</span>
				</p>
				<p>
					<span>${dto.m_nickname }</span>
				</p>
				<p>
					<span>${dto.m_birth    }</span>
				</p>
				<p>
					<span>${dto.m_age      }</span>
				</p>
				<p>
					<span>${dto.m_zipcode  }</span>
				</p>
				<p>
					<span>${dto.m_address1 }${dto.m_address2 }</span>
				</p>
				<p>
					<span>${dto.m_email    }</span>
				</p>
				<p>
					<span>${dto.m_phone    }</span>
				</p>
				<p>
					<span>${dto.m_realGender    }</span>
				</p>
					<span>${dto.m_realGrant   }</span>
				<p>
				</p> 
				<p>
					<span>${dto.m_registdate}</span>
				</p>
			</div>
		</div>
		<div class="btn"></div>
	</div>
</body>
</html>