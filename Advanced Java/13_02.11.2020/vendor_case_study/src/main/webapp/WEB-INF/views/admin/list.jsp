<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor List</title>
</head>
<body>
	<h2>Hello Admin : ${sessionScope.user_credentials.name}</h2>
	<h3>Vendors List</h3>
	<form>
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>City</th>
				<th>Phone Numbers</th>
			</tr>

			<c:forEach var="list" items="${requestScope.vendor_list}">
				<tr>
					<td>${list.name}</td>
					<td>${list.email}</td>
					<td>${list.location.city}</td>
					<td>${list.phoneNumbers}</td>
					<td><a
						href='<spring:url value="/admin/update?vendorId=${list.id}"></spring:url>'>UPDATE</a></td>
					<td><a
						href='<spring:url value="/admin/delete?vendorId=${list.id}"></spring:url>'>DELETE</a></td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href='<spring:url value="/admin/add"></spring:url>'>Add
			New Vendor</a> <br> <br> <br> <a
			href='<spring:url value="/user/logout"></spring:url>'>Logout</a>
	</form>
</body>
</html>