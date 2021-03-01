<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor Bank Details</title>
</head>
<body>
	<h2>Hello ${sessionScope.user_credentials.name}</h2>
	<h3>Bank Account Summary</h3>
	<table>
		<tr>
			<th>Account ID</th>
			<th>Type</th>
			<th>Balance</th>
		</tr>
		<c:forEach var="list" items="${requestScope.vendor_account_list}">
			<tr>
				<td>${list.accountId}</td>
				<td>${list.accountType}</td>
				<td>${list.balance}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href='<spring:url value="/vendor/create_account"></spring:url>'>Create
		Bank Account</a>
	<br>
	<br>
	<a href='<spring:url value="/user/logout"></spring:url>'>Logout</a>



</body>
</html>