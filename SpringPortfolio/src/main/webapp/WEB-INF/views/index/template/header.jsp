<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<c:if test="${not empty sessionScope.login}"> 
	<c:set value="${login.m_grant}" var="grant" />
	<c:set value="${login.m_nickname}" var="nickname" />
	<c:set value="${login.m_id }" var="id" /> 
</c:if>

<header  id="header">
	<div class="container">
		<div class="row">
		<div class="header">
		
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
		
		
			<div class="header_menu">
		<a href="">Blog</a>
		<a href="">Github</a>
		<a href="https://music.youtube.com/"><i class="fa fa-youtube-play" aria-hidden="true"></i>Music</a>
		</div>
		<!-- //header_menu -->
		<div class="header_tit">
			<!-- <h1><span>P</span><span>r</span><span>o</span><span>f</span><span>e</span><span>s</span><span>s</span><span>i</span><span>o</span><span>n</span><span>a</span><span>l</span> <span>w</span><span>e</span><span>b</span> <span>p</span><span>u</span><span>b</span><span>l</span><span>i</span><span>s</span><span>h</span><span>e</span><span>r</span></h1> -->
			<h1>Professional Web Publisher</h1><br>
			<a href="http://webstoryboy.co.kr">webstoryboy.co.kr</a>
		</div>
		<!-- //header_tit -->
		<div class="header_icon">
			<ul>
				<li><a href="" class="html"><i class="fa fa-html5" aria-hidden="true"></i><span>HTML5</span></a></li>
				<li><a href="" class="github"><i class="fa fa-github" aria-hidden="true"></i><span>Github</span></a></li>
				<li><a href="" class="instagram"><i class="fa fa-instagram" aria-hidden="true"></i><span>instagram</span></a></li>
				<li><a href="" class="twitter"><i class="fa fa-twitter" aria-hidden="true"></i><span>twitter</span></a></li>
			</ul>
		</div>
	
	  </div>
	</div>
</div>
</header>
