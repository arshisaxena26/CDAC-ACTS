<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Flights</title>
</head>
<body>
	<h2>Hello ${sessionScope.user_credentials.name}</h2>
	<form:form method="post" modelAttribute="flight"
		action="/flight/search">
		<table>
			<tr>
				<td>From</td>
				<td><form:select path="departureCity">
						<form:options />
					</form:select></td>
			</tr>
			<tr>
				<td>To</td>
				<td><form:select path="arrivalCity">
						<form:options />
					</form:select></td>
			</tr>
			<tr>
				<td>Departure Date</td>
				<td><input type="date" name="date"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Search Flight">
	</form:form>
</body>
</html>