<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty sessionScope.login}"> 
	<c:set value="${login.m_grant}" var="grant" />
	<c:set value="${login.m_nickname}" var="nickname" />
	<c:set value="${login.m_id }" var="id" /> 
</c:if>
<div id="header_wrap">
	<div id="header_menu"> 
		<a href="/">home</a> 
		<c:choose>
			<c:when test="${not empty id }">
				<div id="header_user_info">
					<c:choose>
						<c:when test="${grant != '운영자'}"> 
							<div id="header_user_grant_z">  
								<samp>${grant}${nickname}님 환영합니다.</samp>
							</div>
						</c:when>
						<c:otherwise>
							<span>${nickname}운영자</span>
							<a href="/member/list">list</a>
						</c:otherwise>
					</c:choose>
				</div>
				<a href="/member/read">내정보</a>
				<a href="/account/logout">로그아웃</a>
			</c:when>
			<c:otherwise>
				<a href="/account/login_form">로그인</a>
				<a href="/member/insert">회원가입</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>

