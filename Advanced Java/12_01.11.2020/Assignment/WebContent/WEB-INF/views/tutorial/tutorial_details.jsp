<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutorial Details</title>
</head>
<body>
	<h2>${requestScope.tutorial_details.tutorialName}</h2>
	<br>
	<h4>Author: ${requestScope.tutorial_details.authorName}</h4>
	<h4>Published on: ${requestScope.tutorial_details.publishDate}</h4>
	<h4>Up Votes: ${requestScope.tutorial_details.upVotes}</h4>
	<h4>Content: ${requestScope.tutorial_details.contents}</h4>
</body>
</html>