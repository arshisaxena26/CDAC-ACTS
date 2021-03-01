<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:setProperty property="*" name="voterBean" />

<c:redirect url="${sessionScope.voterBean.authenticatedVoter}.jsp" />

