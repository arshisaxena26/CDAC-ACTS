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
				<td><input type="number" name="cardNumber" required="required" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required="required" /></td>
			</tr>
			<tr>
				<td>Expiry Date</td>
				<td><input type="date" name="expiryDate" required="required" /></td>
			</tr>
			<tr>
				<td>CVV</td>
				<td><input type="password" name="cvv" maxlength="3"
					required="required"></td>
			</tr>
		</table>
		<input type="submit" value="Enter">
	</form:form>
</body>
</html>