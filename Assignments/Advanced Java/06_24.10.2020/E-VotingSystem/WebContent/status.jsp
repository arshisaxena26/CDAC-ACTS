<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Status Page</title>
</head>
<body>
	<jsp:setProperty property="*" name="candidateBean" />
	<h2>Hello,${sessionScope.voter.voter.name}</h2>
	<br>
	<h4>${sessionScope.voterBean.voterStatus}</h4>
	<br> ${sessionScope.candidateBean.setCandidateVotes()}

	<h3>
		<a href="login.jsp">VISIT AGAIN!</a>
	</h3>

	<%
		session.invalidate();
	%>

</body>
</html>