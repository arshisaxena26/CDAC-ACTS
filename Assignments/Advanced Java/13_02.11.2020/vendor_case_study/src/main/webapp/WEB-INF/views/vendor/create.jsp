<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Bank Account</title>
</head>
<body>
	<h2>Form</h2>
	<form:form method="post" modelAttribute="bankAccount">
		<table>
			<tr>
				<td>Account Type :</td>
				<td><form:radiobuttons path="accountType" /></td>
			</tr>
			<tr>
				<td>Opening Balance :</td>
				<td><form:input type="numbers" path="balance" /></td>
			</tr>
		</table>
		<br>
		<br>
		<input type="submit" value="Create Account">
	</form:form>
</body>
</html>