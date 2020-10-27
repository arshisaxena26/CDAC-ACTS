<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate List</title>
</head>
<body>
	<h2>Candidate List</h2>
	<!-- client pull -- URL Rewriting -->
	<form action="<c:url value='status.jsp'/>" method="post">
		<table>
			<tr>
				<td></td>
				<td>Candidate</td>
				<td>Party</td>
			</tr>
			<c:forEach var="list"
				items="${sessionScope.candidateBean.candidateList}">
				<tr>
					<td><input type='radio' name='candidateId'
						value="${list.candidateID}"></td>
					<td>${list.name}</td>
					<td>${list.party}</td>
				</tr>
			</c:forEach>
		</table>
		<input type='submit' value='Vote'>
	</form>
</body>
</html>