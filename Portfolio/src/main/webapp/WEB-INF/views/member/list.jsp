<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="emc" uri="/EMC" %>
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
#search{
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
</head>
<body>
<div id="title">회원목록</div>
<div id="search">
<form action="./list" method="POST">
<select name="col">
	<option value="id" <c:if test="${col=='id' }">selected='selected'</c:if>>아이디</option>
	<option value="email" <c:if test="${col=='email' }">selected='selected'</c:if>>이메일</option>			
	<option value="sex" <c:if test="${col=='sex' }">selected='selected'</c:if>>성별</option>			
	<option value="grade" <c:if test="${col=='grade' }">selected='selected'</c:if>>등급</option>		
	<option value="total">전체</option>	
</select>
	<input type="text" name="word" value="${word }"/>
	<input type="submit" value="검색"/>
</form>
</div>
<div id="content">
<c:choose>
<c:when test="${fn:length(list)>0 }">
<c:forEach items="${list }" var="dto">
<table>
<tr>
<th colspan="2">프로필사진</th>
</tr>
<tr>
<th colspan="2"><img src="${pageContext.request.contextPath }/storage/member/${dto.photo}"></th>
</tr>
<tr>
<th>아이디</th>
<td>${dto.id }</td>
</tr>
<tr>
<th>닉네임</th>
<td>${dto.nickname }</td>
</tr>
<tr>
<th>이메일</th>
<td>${dto.email1}${dto.at }${dto.email2 }</td>
</tr>
<tr>
<th>성별</th>
<td>${dto.sex}</td>
</tr>
<tr>
<th>등급</th>
<td>${emc:getGrade(dto.grade)}</td> 
</tr>
</table>
</c:forEach>
</c:when>
<c:otherwise>
<table>
<tr>
<th>프로필사진</th>
<td colspan="6">등록된 회원이 없습니다.</td>
</tr>
<tr>
<th>아이디</th>
</tr>
<tr>
<th>닉네임</th>
</tr>
<tr>
<th>이메일</th>
</tr>
<tr>
<th>성별</th>
</tr>
<tr>
<th>등급</th>
</tr>
</table>
</c:otherwise>
</c:choose>
<div>
${paging}
</div>
</div>
</body>
</html>