<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html> 
<html>
<head> 
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<tiles:insertAttribute name="default_css" />
<tiles:insertAttribute name="transform_css" />
<tiles:insertAttribute name="default_js" />
<tiles:insertAttribute name="transform_js" />
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<main>
		<tiles:insertAttribute name="content" />
	</main>
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>