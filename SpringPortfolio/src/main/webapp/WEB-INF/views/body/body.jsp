<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html> 
<html>
<head> 
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width initial-scale=1">
<title><tiles:insertAttribute name="title" /></title>
<tiles:insertAttribute name="library"/>
<tiles:insertAttribute name="css" />
<tiles:insertAttribute name="js" />
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