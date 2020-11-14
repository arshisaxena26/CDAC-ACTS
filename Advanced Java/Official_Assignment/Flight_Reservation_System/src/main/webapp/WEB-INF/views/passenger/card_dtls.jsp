<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Card Details Form</title>
</head>
<body>
	<h2>Enter Card Details</h2>
	<form:form method="post" action="/passenger/card"
		modelAttribute="cardDetails">
		<table>
			<tr>
				<td>Card Number</td>
				<td><form:input type="number" path="cardNumber" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Expiry Date</td>
				<td><form:input type="date" path="expiryDate" /></td>
			</tr>
			<tr>
				<td>CVV</td>
				<td><input type="password" name="cvv" maxlength="3"></td>
			</tr>
		</table>
		<input type="submit" value="Enter">
	</form:form>
</body>
</html>