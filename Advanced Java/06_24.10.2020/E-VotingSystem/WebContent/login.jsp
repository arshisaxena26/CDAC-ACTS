<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>

<jsp:useBean id="voterBean" class="beans.VoterBean" scope="session" />
<jsp:useBean id="candidateBean" class="beans.CandidateBean"
	scope="session" />

<body>
	<h1>Voter Login Form</h1>
	<h4>${sessionScope.voterBean.message}</h4>
	<form action="validate.jsp" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>