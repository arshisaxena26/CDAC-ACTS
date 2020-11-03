<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topic List</title>
</head>
<body>
	<h2>Topic List</h2>
	<form action="tutorial_lists" method="post">
		<table>
			<c:forEach var="list" items="${requestScope.topic_list}">
				<tr>
					<td><input type='radio' name='topicID' value="${list.topicId}"></td>
					<td>${list.topicName}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <input type='submit' value='Choose Topic'>
	</form>
</body>
</html>