<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutorial List</title>
</head>
<body>
	<h2>Tutorial List</h2>
	<c:forEach var="list" items="${requestScope.tutorial_list}">
		<h4>
			<a href="tutorial_details?tutorialID=${list.tutorialId}">${list.tutorialName}</a>
		</h4>
	</c:forEach>
</body>
</html>