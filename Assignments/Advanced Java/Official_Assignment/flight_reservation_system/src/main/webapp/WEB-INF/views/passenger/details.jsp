<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<style>
h4 {
	color: darkblue;
}
</style>
<meta charset="UTF-8">
<title>Passenger Form</title>
</head>
<body>
	<h2>Hello, ${sessionScope.user_credentials.name}</h2>
	<h3>You have chosen : Flight Details -</h3>
	<h4>Airline : ${requestScope.selected_flight.airline}</h4>
	<h4>Departure City : ${requestScope.selected_flight.departureCity}</h4>
	<h4>Arrival City : ${requestScope.selected_flight.arrivalCity}</h4>

	<h3>Enter Passenger Details</h3>

	<form:form method="post" modelAttribute="passenger"
		action="/passenger/details?flightId=${requestScope.selected_flight.flightId}">
		<table>
			<tr>
				<td>Passenger Name</td>
				<td><input type="text" name="name" required="required" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" required="required" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="number" name="phone" required="required" /></td>
			</tr>
		</table>
		<input type="submit" value="Enter Details">
	</form:form>
</body>
</html>