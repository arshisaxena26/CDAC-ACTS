<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>
	<h2>Hello, ${sessionScope.voterBean.voter.name}</h2>
	<br>
	<h3>TOP CANDIDATES:</h3>
	<br>
	<table>
		<tr>
			<th>Name</th>
			<th>Votes</th>
		</tr>
		<c:forEach var="list"
			items="${sessionScope.candidateBean.topCandidates}">
			<tr>
				<td>${list.name}</td>
				<td>${list.votes}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<h3>Party-Wise Analysis:</h3>
	<br>
	<table>
		<tr>
			<th>Party</th>
			<th>Votes</th>
		</tr>
		<c:forEach var="list" items="${sessionScope.candidateBean.partyVotes}">
			<tr>
				<td>${list.party}</td>
				<td>${list.votes}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<h2>
		<a href="login.jsp">VISIT AGAIN!</a>
	</h2>

	<%
		session.invalidate();
	%>

</body>
</html>