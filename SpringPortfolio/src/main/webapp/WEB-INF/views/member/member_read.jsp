<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="/resources/css/member/read.css">
<title></title>
</head>
<body>
	<div class="container">
	
		<div class="box">
			<div class="content">
			   <h2>Profile</h2>
			    <div class="profile">
				<h3>${dto.m_index}</h3>
				<p>아이디:</p>
				<p>닉네임:</p>
				</div>
				<div class="profile2">
               
                <p>${dto.m_id}</p>
                <p>${dto.m_nickname}</p>
                </div>
    			<a href="#" >Read More</a>
				</div>
			</div>
			
			<div class="box">
			   <div class="content">
			    <div class="profile">
    			<p>회원이름:</p>
    			<p>생일:</p>
    			<p>나이:</p>
    			<p>성별:</p>
    			</div>
    			<div class="profile2">
    			<p>${dto.m_name}</p>
    			<p>${dto.m_birth}</p>
    			<p>${dto.m_age}</p>
    			<p>${dto.m_realGender}</p>
    			<a href="#" >Read More</a>
    			</div>
    		</div>
			</div>
			
			
			<div class="box">
			   <div class="content">
			    <div class="profile">
    			<p>우편번호:</p>
    			<p>주소:</p>
    			<p>이메일:</p>
    			<p>전화번호:</p>
    			</div>
    			<div class="profile2">
    			<p>${dto.m_zipcode}</p>
    			<p>${dto.m_address1 }${dto.m_address2 }</p>
    			<p>${dto.m_email}</p>
    			<p>${dto.m_phone}</p>
    			<a href="#" >Read More</a>
    			</div>
    		</div>
			</div>
			
				<div class="box">
			   <div class="content">
			    <div class="profile">
    			<p>등급:</p>
    			<p>가입일짜:</p>
    			</div>
    			<div class="profile2">
    			<p>${dto.m_realGrant}</p>
    			<p>${dto.m_registdate}</p>
    			<a href="#" >Read More</a>
    			</div>
    		</div>
			</div>
			</div>
				
		<div class="btn"></div>
	
</body>
</html> --%>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="/resources/css/member/read.css">
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
   <div class="container">
       <div class="box">
          <div class="content">
             <h2 >프로필</h2>
             <h3>{회원 번호}</h3>
             <p>이름    :                간지</p>
             <a href="#" >Read More</a>
          </div>
       </div>
       <div class="box">
          <div class="content">
             <h2>02</h2>
             <h3>Service Two</h3>
             <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation umollit anim id est laborum.</p>
             
             <a href="#" >Read More</a>
          </div>
       </div>
       <div class="box">
          <div class="content">
             <h2>03</h2>
             <h3>Service Three</h3>
             <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation umollit anim id est laborum.</p>
             
             <a href="#" >Read More</a>
          </div>
       </div>
       <div class="box">
          <div class="content">
             <h2>04</h2>
             <h3>Service Four</h3>
             <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation umollit anim id est laborum.</p>
             
             <a href="#" >Read More</a>
          </div>
       </div>
    </div>
</body>

 --%>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" href="/resources/css/member/read.css">
   <title></title>
</head>
<body>
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
             <a href="#" >Read More</a>
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
             <a href="#" >Read More</a>
          </div>
       </div>
       
       <div class="box">
          <div class="content">
             
             
             <div class="prfile5">
             <p>우편번호:</p>
             <p>주소:</p>
             <p>상세주소:</p>
             <p>이메일:</p>
             <p>전화번호:</p>
             </div>
             <div class="profile6">
             <p>${dto.m_zipcode}</p>
             <p>${dto.m_address1}</p>
             <p>${dto.m_address2}</p>
             <p>${dto.m_email}</p>
             <p>${dto.m_phone}</p>
             </div>
             <a href="#" >Read More</a>
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
          
             
             <a href="#" >Read More</a>
          </div>
       </div>
       
    </div>
</body>
</html>