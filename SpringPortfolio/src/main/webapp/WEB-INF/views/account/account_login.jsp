<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <section>
  <video id="slider" autoplay  loop>
      <source src="/resources/common/storage/video/Kassy.mp4" type="video/mp4">
    </video>

    <ul class="navigation">
      <li  id="first" first='/resources/common/storage/video/Kassy.mp4' onclick="videoURL('/resources/common/storage/video/Kassy.mp4')" ><img src="/resources/common/storage/image/blueming.jpg"></li>
      <li onclick="videoURL('/resources/common/storage/video/blueming.mp4')"><img src="/resources/common/storage/image/kassy.jpg"></li>
      <li onclick="videoURL('/resources/common/storage/video/palette.mp4')"><img src="/resources/common/storage/image/palette.jpg"></li>
      <li onclick="videoURL('/resources/common/storage/video/bibi.mp4')"><img src="/resources/common/storage/image/bibi.jpg"></li>
    </ul>

</section>


<div class="login" id="account_form">
   
<form class="box" action="/account/login" method="post" onSubmit="return false;">
 <h1>로그인</h1>

 <div id="account_input_id">
  <input type="text" name="m_id" id="m_id" placeholder="아이디" value="${not empty m_id?m_id:'' }" >
 </div>


<div id="account_input_password">
  <input type="password" name="m_password" id="m_password" placeholder="비밀번호">
</div>

   <div id="account_fail_msg" class="fail">
        <strong>${not empty msg?msg:'&nbsp;' }</strong>
      </div>

<div id="account_form_submit" class="auto">
      <input type="checkbox" name="a_autologin_check" value="off" id="autologin"/>
  <label for="autologin">자동로그인</label> 
</div>

<div class="submit">
  <input id="form_submit" type="submit" name="" value="로그인">
</div>

</form>
	
<div id="account_button" class="button">
<a href="#">아이디 찾기</a> 
  <a href="#">비밀번호 찾기</a>
  <a href="/member/insert">회원가입</a>
</div>
</div>
   
