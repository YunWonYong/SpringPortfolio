<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="jquery-3.4.1.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<th>아이디:</th>
			<th>${dto.m_id }</th>
		</tr>
		<tr>
			<td>등급:</td>
			<td>${dto.m_grant }</td>
		</tr>
	</table>
</body>
</html>