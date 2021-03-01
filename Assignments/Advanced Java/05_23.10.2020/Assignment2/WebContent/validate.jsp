<%@page import="pojos.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>

<%--JSP Declaration Block --%>
<%!String validName = "abc";
	String validPassword = "1234";%>

<body>

	<%--Scriptlet --%>
	<%
		String name = request.getParameter("name");
	String password = request.getParameter("pass");

	if (name.equals(validName) && password.equals(validPassword)) {
		//Server Pull
		request.setAttribute("user_details", new User(name, password));
		RequestDispatcher reqDispatch = request.getRequestDispatcher("details.jsp");
		reqDispatch.forward(request, response);
	} else {
	%>

	<h4>Invalid Credentials</h4>
	<br>
	<h3>
		<a href='login.jsp'>RETRY!</a>
	</h3>

	<%--Using another Scriptlet to close else logic --%>
	<%
		}
	%>
</body>
</html>