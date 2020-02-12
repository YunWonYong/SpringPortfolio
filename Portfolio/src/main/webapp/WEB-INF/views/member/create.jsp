<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#title{
margin: auto;
text-align: center;
}
#button{
margin: auto;
text-align: center;
}
table{ 
margin: auto;
text-align:center; 
}
table,th,td{
 border: 1px solid black;
}
</style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>

<script>
   function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수
 
                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;
 
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }
 
                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;
 
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script> 
<script type="text/javascript">
function inputCheck(f){
	if(f.id.value==""||f.id.value==null){
		alert("아이디를 입력해 주세요");
		f.id.focus();
		return false;
	}
	if(f.passwd.value==""||f.passwd.value==null){
		alert("비밀번호를 입력해 주세요");
		f.passwd.focus();
		return false;
	}
	if(f.passwdCheck.value==""||f.passwdCheck.value==null){
		alert("비밀번호를 체크해주세요");
		f.passwdCheck.focus();
		return false;
	}
	if(f.passwd.value!=f.passwdCheck.value){
		alert("입력하신 비밀번호와 같지 않습니다");
		f.passwd.focus();
		return false;
	}
}
</script>
<script type="text/javascript">
function idCheck(id){
	var url="${pageContext.request.contextPath}/member/idCheck?id="+id;
	window.open(url,"IDCheck","width=500, height=500");
}
$(document).ready(function(){
	var nickname=$("#nickCheck1");
	if(nickname.value==null){
		$("#nickCheck2").text("한글은2글자 영문은 4글자이상 써주세요");
	}else if (nickname.value!=null||nickname.value!=""){
		$("#nickCheck2").text("중복확인");
	}
});
</script>
<script type="text/javascript">
function emailWrite(ew){
	var m=document.getElementById("email3");
	if(ew.value=="write"){
    m.style.display="inline";
	}else{
	m.style.display="none";
	}
}
</script>
</head>
<body>
	<div id="title"><h1>회원가입</h1></div>
	<div id="content">
	<form action="./createProc" method="POST" enctype="multipart/form-data" onsubmit="return inputCheck(this)">
		<table>
			<tr>
			<th>이름</th>
			<td><input type="text" name="name"/></td>
			</tr>
			<tr>
			<th>생년월일</th>
			<td>
			<input type="text" name="year" size="4" maxlength="4" />년
			<input type="text" name="month" size="2" maxlength="2"/>월
			<input type="text" name="day" size="2" maxlength="2"/>일
			</td>
			</tr>
			<tr>
			<th>성별</th>
			<td>
			<label>
			<input type="radio" name="sex" value="남자"/>남자
			</label>
			<label>
			<input type="radio" name="sex" value="여자"/>여자
			</label>
			</td> 
			</tr>
			<tr>
			<th>아이디</th>
			<td>
			<input type="text" name="id"/>
			<input type="button" onclick="idCheck(this.form.id.value)" value="아이디중복확인"/>
			</td>
			</tr>
			<tr>
			<th>닉네임</th>
			<td>
			<input type="text" id="nickCheck1" name="nickname"/>
			<div id="nickCheck2"></div>
			</td>
			</tr>
			<tr>
			<th>비밀번호</th>
			<td><input type="password" name="passwd"/></td>
			</tr>
			<tr>
			<th>비밀번호확인</th>
			<td><input type="password" name="passwdCheck"/></td>
			</tr>
			<tr>
			<th>이메일</th>
			<td><input type="text" name="email1" size="12"/>@<input type="text" id="email3" name="email2" style="display:none;" size="12"/>
												   <select name="email2" onchange="emailWrite(this)">
												   <option value="" >선택</option>
												   <option value="naver.com">naver.com</option>				
												   <option value="nate.com">nate.com</option>
												   <option value="hanmail.net">hanmail.net</option>
												   <option value="gmail.com">gmail.com</option>
												   <option value="yahoo.co.kr">yahoo.co.kr</option>
												   <option value="write">직접입력</option>
												   </select></td>
			</tr>
			<tr>
			<th>집전화번호</th>
			<td>
			<input type="text" name="zipnumber1" size="3" maxlength="3"/>-
			<input type="text" name="zipnumber2" size="4" maxlength="4"/>-
			<input type="text" name="zipnumber3" size="4" maxlength="4"/>
			</td>
			</tr>
			<tr>
			<th>핸드폰번호</th>
			<td>
			<input type="text" name="phone1" size="3" maxlength="3">-
			<input type="text" name="phone2" size="4" maxlength="4"/>-
			<input type="text" name="phone3" size="4" maxlength="4"/>
			</td>
			</tr>
			<tr>
			<tr>
			<th>우편번호</th>
 			<td>
 			<input type="text" name="zipcode" size="7" id="sample6_postcode"/>
 			<input type="button" value="우편번호찾기" onclick="sample6_execDaumPostcode()">
 			</td>
			<tr>
			<tr>
			<th>주소</th>
			<td><input type="text" name="address1" size="40" id="sample6_address" /></td>
			</tr>
			<tr>
			<th>상세주소</th>
			<td><input type="text" name="address2" size="40" id="sample6_address2"/></td>
			</tr>
			<tr>
			<th>취미</th>
			<td>
			<select name="hobby">
			<option value="">선택</option>
			<option value="운동">운동</option>
			<option value="독서">독서</option>
			<option value="여행">여행</option>
			</select>
			</td>
			</tr>
			<tr>
			<th>프로필사진</th>
			<td><input type="file" name="fileMF"></td>
			</tr>
		</table>
		<div id="button"> 
		<input type="submit" value="등록"/>
		<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}'"/>
		</div>
	</form>
	</div>
</body>
</html>