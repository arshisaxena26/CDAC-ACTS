<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Status Page</title>
</head>
<body>
	<h2>Reservation Done with ID :
		${sessionScope.passenger.reservationId}</h2>
	<h3>
		<a href='<spring:url value="/user/logout"></spring:url>'>LOGOUT</a>
	</h3>

</body>
</html>