<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Flight Details</title>
</head>
<body>
	<table>
		<tr>
			<th>Airline</th>
			<th>FROM</th>
			<th>TO</th>
			<th>Time</th>
			<th></th>
		</tr>
		<c:forEach var="list" items="${requestScope.flight_list}">
			<tr>
				<td>${list.airline}</td>
				<td>${list.departureCity}</td>
				<td>${list.arrivalCity}</td>
				<td>${list.departureTime}</td>
				<td><a
					href='<spring:url value="/passenger/details?flightId=${list.flightId}"></spring:url>'>select</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>