<%@ page contentType="text/html; charset=UTF-8" %> 
<!DOCTYPE html> 
<html> 
<head> 


<meta charset="UTF-8"> 
<title></title> 
<script type="text/javascript">
</script>

<link href="${pageContext.request.contextPath}/css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
<input type="hidden" name="thumbnail" value="${dto.thumbnail }">
<iframe src='${dto.thumbnail }' width='400' height='200' frameborder='1' ></iframe>
</body>
</html> 