<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
	function fileInfo(f) {
		var file = f.files;
		var reader = new FileReader();
		reader.onload = function(rst) {
			$("#fileView").html("<img src='"+rst.target.result+"'>");
		}
		reader.readAsDataURL(file[0]);
	}
</script>
</head>
<body>
<form action="./filupdateProc" enctype="multipart/form-data" method="POST">
<input type="hidden" name="id" value="${id }"/>
<input type="hidden" name="oldFile" value="${photo }"/>
<div id="title"><h1>파일수정</h1></div>
<table>
<tr>
<th>아이디</th>
<td>${id }</td>
</tr>
<tr>
<th>기존파일</th>
<td><img src="${pageContext.request.contextPath }/storage/member/${photo }"/></td>
</tr>
<tr>
<Th>변경할파일</Th>
<td>
<input type="file" name="fileMF" onchange="fileInfo(this)"accept=".jpg,.png"/>
<div id="fileView"></div>
</td> 
</tr>
</table>
<div id="button">
<input type="submit" value="수정"/>
<input type="button" value="뒤로가기" onclick="history.back(1)"/>
</div>
</form>
</body>
</html>