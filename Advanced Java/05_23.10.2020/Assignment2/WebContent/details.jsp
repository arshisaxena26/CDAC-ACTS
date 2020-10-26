<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
</head>
<body>
	<h3>User Details: ${requestScope.user_details}</h3>
	
	<%--Scriptlet to broaden the scope from request to session as attributes will be required for next JSP --%>
	<%
		session.setAttribute("user_details", request.getAttribute("user_details"));
	%>

	<br>
	<h3>
		<a href="logout.jsp">LOG ME OUT</a>
	</h3>
</body>
</html>