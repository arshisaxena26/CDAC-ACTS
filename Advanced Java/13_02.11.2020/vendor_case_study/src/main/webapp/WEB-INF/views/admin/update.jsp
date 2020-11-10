<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor Details Updation Form</title>
</head>
<body>
	<form:form method="post" modelAttribute="vendor">
		<table>
			<tr>
				<td>City :</td>
				<td><form:input path="location.city" /></td>
			</tr>
			<tr>
				<td>Phone Numbers :</td>
				<td><form:input path="phoneNumbers" /></td>
			</tr>
		</table>
		<input type="submit" value="Update">
	</form:form>
</body>
</html>