<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Page</title>
</head>
<body>
	<h3>Hello, ${sessionScope.user_details.name}</h3>

	<%--Using Scriptlet to invalidate session --%>
	<%
		session.invalidate();
	%>

	<br>
	<h3>Logout Successful</h3>
	<br>
	<h2>
		<a href="index.jsp">VISIT AGAIN!</a>
	</h2>

</body>
</html>