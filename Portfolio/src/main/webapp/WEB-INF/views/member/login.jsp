<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
table{
margin: auto;
text-align: center;
}
#button{
margin: auto;
text-align: center;
}
</style>
</head>
<body> 
<div id="title"><h1>로그인</h1></div>
<div id="content">
<form action="./loginProc" method="POST" >
	<table> 
	<tr>
	<th>아이디</th>
	<td><input type="text" name="id"/></td>
	</tr>
	<tr>
	<th>비밀번호</th>
	<td><input type="password" name="passwd"/></td> 
	</tr>
	</table>
	<div id="button">
	<input type="submit" value="로그인"/>
	<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}'"/>
	</div>
</form>
</div>
</body>
</html>