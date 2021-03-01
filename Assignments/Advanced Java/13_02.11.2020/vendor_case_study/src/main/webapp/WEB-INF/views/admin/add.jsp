<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor Registration Form</title>
</head>
<body>
	<h2>Vendor Registration Form</h2>
	<form:form method="post" modelAttribute="vendor">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><form:input path="location.city" /></td>
			</tr>
			<tr>
				<td>Phone Numbers :</td>
				<td><form:input path="phoneNumbers" /></td>
			</tr>
		</table>
		<br>
		<br>
		<input type="submit" value="Register">
	</form:form>
</body>
</html>