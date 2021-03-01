<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>User Login Form</h1>
	<h2>${requestScope.message}</h2>
	<form method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" required="required"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" required="required" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>