.<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container">
		<div class="box">
			<div class="content">
				<div class="profile1">
					<p>회원번호:</p>
					<p>아이디:</p>
					<p>닉네임:</p>
				</div>
				<div class="profile2">
					<p>${dto.m_index}</p>
					<p>${dto.m_id}</p>
					<p>${dto.m_nickname}</p>
				</div>
				<a href="/member/update/identify">정보수정</a>
			</div>
		</div>
		<div class="box">
			<div class="content">
				<div class="profile3">
					<p>회원이름:</p>
					<p>생일:</p>
					<p>나이:</p>
					<p>성별:</p>
				</div>
				<div class="profile4">
					<p>${dto.m_name}</p>
					<p>${dto.m_birth}</p>
					<p>${dto.m_age}</p>
					<p>${dto.m_realGender}</p>
				</div>
				<a href="/member/update/userinfo">정보수정</a>
			</div>
		</div>
		<div class="box">
			<div class="content">
				<div class="prfile5">
					<p>전화번호:</p>
					<p>우편번호:</p>
					<p>주소:</p>
					<p>상세주소:</p>
					<p>이메일:</p>
				</div>
				<div class="profile6">
					<p>${dto.m_phone}</p>
					<p>${dto.m_zipcode}</p>
					<p>${dto.m_address1}</p>
					<p>${dto.m_address2}</p>
					<p>${dto.m_email}</p>
				</div>
				<a href="/member/update/useraddress">정보수정</a>
			</div>
		</div>
		<div class="box">
			<div class="content">
				<div class="profile7">
					<p>등급:</p>
					<p>가입일짜:</p>
				</div>
				<div class="profile8">
					<p>${dto.m_realGrant}</p>
					<p>${dto.m_registdate}</p>
				</div>
				<c:if test="${dto.m_realGrant eq '운영자'}">
					<a href="/member/update/grantupdate">정보수정</a>
				</c:if>
			</div>
		</div>

	</div>